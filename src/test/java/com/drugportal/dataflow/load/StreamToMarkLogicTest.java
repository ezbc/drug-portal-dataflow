package com.drugportal.dataflow.load;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.FileSystems;
import org.apache.beam.sdk.io.fs.ResolveOptions.StandardResolveOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.testing.FileChecksumMatcher;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.testing.TestPipelineOptions;
import org.apache.beam.sdk.transforms.DoFnTester;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.drugportal.dataflow.load.StreamToMarkLogic.*;
import com.drugportal.dataflow.load.StreamToMarkLogic.LoadOptions;

/**
 * End-to-end tests of WordCount.
 */
@RunWith(JUnit4.class)
public class StreamToMarkLogicTest {
	private static final String DEFAULT_TOPIC = "dataset-fda-status";
	private static final String DEFAULT_OUTPUT_CHECKSUM = "ebf895e7324e8a3edc72e7bcc96fa2ba7f690def";

	/**
	 * Options for the WordCount Integration Test.
	 *
	 * <p>
	 * Define expected output file checksum to verify WordCount pipeline result with
	 * customized input.
	 */
	public interface LoadOptionsTest extends TestPipelineOptions, LoadOptions {
	}

	@BeforeClass
	public static void setUp() {
		PipelineOptionsFactory.register(TestPipelineOptions.class);
	}

	public void testE2EStreamToMarkLogic() throws Exception {
		LoadOptions options = TestPipeline.testingPipelineOptions().as(LoadOptions.class);

		options.setPubsubTopic(DEFAULT_TOPIC);

		Pipeline p = TestPipeline.create();

	}
	
	@Test
	public void testEnvelopeContent() throws Exception {
		EnvelopeContentFn envelopeContentFn = new EnvelopeContentFn();
		DoFnTester<String, String> fnTester = DoFnTester.of(envelopeContentFn);
		String testInput = "{'contentKey1': 'contentValue1'}";
		@SuppressWarnings("deprecation")
		List<String> testOutputs = fnTester.processBundle(testInput);
		
		Assert.assertThat(testOutputs, CoreMatchers.hasItems("{\"envelope\":{\"header\":{},\"content\":{\"contentKey1\":\"contentValue1\"}}}"));
	}
}