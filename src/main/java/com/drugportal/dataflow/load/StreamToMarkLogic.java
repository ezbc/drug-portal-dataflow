/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.drugportal.dataflow.load;

import java.io.IOException;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.options.Validation.Required;
import org.apache.beam.sdk.options.ValueProvider;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drugportal.sources.DataSource;
import com.drugportal.sources.DataSourceFactory;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.DatabaseClientFactory.DigestAuthContext;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.StringHandle;

/**
 * A starter example for writing Beam programs.
 *
 * <p>
 * The example takes two strings, converts them to their upper-case
 * representation and logs them.
 *
 * <p>
 * To run this starter example locally using DirectRunner, just execute it
 * without any additional parameters from your favorite development environment.
 *
 * <p>
 * To run this starter example using managed resource in Google Cloud Platform,
 * you should specify the following command-line options:
 * --project=<YOUR_PROJECT_ID>
 * --stagingLocation=<STAGING_LOCATION_IN_CLOUD_STORAGE> --runner=DataflowRunner
 */
public class StreamToMarkLogic {
	private static final Logger LOG = LoggerFactory.getLogger(StreamToMarkLogic.class);

	/**
	 * Options supported by {@link WordCount}.
	 *
	 * <p>
	 * Concept #4: Defining your own configuration options. Here, you can add your
	 * own arguments to be processed by the command-line parser, and specify default
	 * values for them. You can then access the options values in your pipeline
	 * code.
	 *
	 * <p>
	 * Inherits standard configuration options.
	 */
	public interface LoadOptions extends PipelineOptions {

		@Description("Topic to read from")
		@Default.String("load-to-marklogic")
		String getPubsubTopic();

		void setPubsubTopic(String value);

		@Description("MarkLogic Host")
		@Required
		ValueProvider<String> getHost();

		void setHost(ValueProvider<String> value);

		@Description("MarkLogic Port")
		@Required
		ValueProvider<Integer> getPort();
		void setPort(ValueProvider<Integer> value);

		@Description("MarkLogic Database")
		@Required
		ValueProvider<String> getDatabase();
		void setDatabase(ValueProvider<String> value);

		@Description("MarkLogic User")
		@Required
		ValueProvider<String> getUser();

		void setUser(ValueProvider<String> value);

		@Description("MarkLogic Password")
		@Required
		ValueProvider<String> getPassword();

		void setPassword(ValueProvider<String> value);

	}

	public static class LogFn extends DoFn<String, String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@ProcessElement
		public void processElement(ProcessContext c) {
			// LOG.info(c.element());
			// System.out.println(c.element());
		}
	}

	// TODO Create a database client factory
	public static class MarkLogicIoFn extends DoFn<String, String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public DatabaseClient client;
		public ValueProvider<String> host;
		public ValueProvider<String> database;
		public ValueProvider<String> user;
		public ValueProvider<String> password;
		public ValueProvider<Integer> port;
		
		public MarkLogicIoFn(LoadOptions loadOptions) {
			this.host = loadOptions.getHost();
			this.database = loadOptions.getDatabase();
			this.user = loadOptions.getUser();
			this.password = loadOptions.getPassword();
			this.port = loadOptions.getPort();
		}
		
		/** Create a connection with the client.
		 * 
		 */
		public void initializeClient() {
			 // TODO separate marklogic API client initialization
			 this.client = DatabaseClientFactory.newClient(host.get(),
			 port.get(), database.get(), new
			 DigestAuthContext(user.get(), password.get()));
		}

		/** Initialize any clients at the bundle runtime context in order
		 * establish expensive connections for a group of element processing
		 * steps.
		 * @param startBundleContext the runtime context
		 */
		@StartBundle
		public void startBundle(StartBundleContext startBundleContext) {

			initializeClient();
			System.out.println("starting bundle");
			System.out.println(this.host);
		}

		@ProcessElement 
		public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
			
			// TODO separate the MarkLogic document construction logic from the dataflow package
			JSONDocumentManager docMgr = this.client.newJSONDocumentManager();
						
			// create a handle on the content
			StringHandle handle = new StringHandle(c.element());
			
			// create a data source
			DataSource source = DataSourceFactory.getDataSource("generic");
			String uri = source.buildUri();
			
			// write the document content
			docMgr.write(uri, handle);
		}
	}

	public static class EnvelopeContentFn extends DoFn<String, String> {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@ProcessElement
		public void processElement(ProcessContext c) throws JsonParseException, JsonMappingException, IOException {
		
			JSONObject message = new JSONObject(c.element());
			JSONObject envelope = new JSONObject();
			envelope.put("envelope", message);
			/*
			JSONObject envelope = new JSONObject("{'envelope': {}}");
			try {
				JSONObject header = message.getJSONObject("header");
				envelope.getJSONObject("envelope").put("header", header);
			} catch (JSONException error) {
				System.out.println(message.toString());
			}

			try {
				JSONObject content = message.getJSONObject("content");
				envelope.getJSONObject("envelope").put("content", content);
			} catch (JSONException error) {
				System.out.println(message.toString());
			}*/
			
			c.output(envelope.toString());
		}
	}
	
	public static void main(String[] args) {

		// construct pipeline options
		LoadOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(LoadOptions.class);
		Pipeline p = Pipeline.create(options);

		System.out.println("starting pipeline...");
		// read messages from pubsub
		p.apply(PubsubIO.readStrings().fromTopic(options.getPubsubTopic()))
		 //.apply(ParDo.of(new LogFn()))
		 .apply(ParDo.of(new EnvelopeContentFn()))
		 .apply(ParDo.of(new MarkLogicIoFn(options)));
		p.run();
	}
}
