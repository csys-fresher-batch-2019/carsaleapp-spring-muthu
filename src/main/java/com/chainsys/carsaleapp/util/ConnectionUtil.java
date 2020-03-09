package com.chainsys.carsaleapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
			TimeZone.setDefault(timeZone);
			String server = "192.168.56.217";
			String userName = "kannan";
			String pass = "muthu";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@" + server + ":1521:XE";
			connection = DriverManager.getConnection(url, userName, pass);
			System.out.println(connection);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver class not found");
		} catch (SQLException e) {

			throw new RuntimeException("invalid DB credentials" + e.getMessage());
		}
		return connection;
	}

}
