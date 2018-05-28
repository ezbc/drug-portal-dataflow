package com.drugportal.sources;

import com.drugportal.business.datasources.FDA;

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
		}
		return null;
	}
}
