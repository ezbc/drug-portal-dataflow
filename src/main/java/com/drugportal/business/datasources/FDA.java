package com.drugportal.business.datasources;

import java.util.UUID;

import com.drugportal.sources.DataSource;

/**
 * @author ezbc
 * FDA data source from openFDA.
 */
public class FDA extends DataSource {

	@Override
	public String buildUri() {
		String uri = "/fda/" + UUID.randomUUID().toString() + ".json";
		return uri;
	}

}
