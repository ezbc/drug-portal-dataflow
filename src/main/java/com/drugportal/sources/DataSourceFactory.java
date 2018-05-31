package com.drugportal.sources;

import com.drugportal.business.datasources.FDA;
import com.drugportal.business.datasources.Generic;

/**
 * @author ezbc
 *
 */
public class DataSourceFactory {

	/**
	 * @param type Data source type to create an instance of
	 * @return data source instance
	 */
	public static DataSource getDataSource(String type) {
		if ("fda".equalsIgnoreCase(type)) {
			return new FDA();
		} else {
			return new Generic();
		}
	}
}
