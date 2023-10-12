package com.infinite.util;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Database {
	private static DataSource datasource = null;

	public static DataSource getDataSource() {
		if (datasource == null) {
			HikariConfig c = new HikariConfig();
			c.setJdbcUrl("jdbc:mysql://localhost:3306/train");
			c.setUsername("root");
			c.setPassword("mysql123@");
			c.setMaximumPoolSize(10);
			c.setAutoCommit(true);
			c.addDataSourceProperty("cachePrepStmts", "true");
			c.addDataSourceProperty("prepStmtCacheSize", "250");
			c.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
			datasource = new HikariDataSource(c);
		}
		return datasource;
	}
}
