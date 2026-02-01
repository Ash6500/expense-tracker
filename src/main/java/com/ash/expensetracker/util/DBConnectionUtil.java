package com.ash.expensetracker.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnectionUtil {
	private static HikariDataSource dataSource;

	static {
		try {
			Properties props = new Properties();
			InputStream is = DBConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties");

			if (is == null) {
				throw new RuntimeException("db.properties not found");
			}

			props.load(is);

			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(props.getProperty("db.url"));
			config.setUsername(props.getProperty("db.username"));
			config.setPassword(props.getProperty("db.password"));
			config.setDriverClassName(props.getProperty("db.driver"));

//			pool tuning (interview gold)
			config.setMaximumPoolSize(10);
			config.setMinimumIdle(2);
			config.setIdleTimeout(30000);
			config.setConnectionTimeout(30000);
			config.setMaxLifetime(1800000);

			dataSource = new HikariDataSource(config);

		} catch (Exception e) {
			// TODO: handle exception
			throw new ExceptionInInitializerError(e);
		}
	}

	private DBConnectionUtil() {
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
