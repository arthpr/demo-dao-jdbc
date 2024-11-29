package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties p = LoadProperties();
				String url = p.getProperty("dburl");
				conn = DriverManager.getConnection(url, p);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void CloseConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties LoadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties p = new Properties();
			p.load(fs);
			return p;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void CloseStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
