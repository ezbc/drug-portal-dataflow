package com.drugportal.business.datasources;

import java.util.UUID;

import com.drugportal.sources.DataSource;

/**
 * @author ezbc
 * FDA data source from openFDA.
 */
public class Generic extends DataSource {

	@Override
	public String buildUri() {
		String uri = "/" + UUID.randomUUID().toString() + ".json";
		return uri;
	}

}
