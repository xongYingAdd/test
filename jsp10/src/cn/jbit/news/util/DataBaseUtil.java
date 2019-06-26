package cn.jbit.news.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {

	private static String driver = ConfigManager.getProperty("driver");// 数据库驱动字符串
	private static String url = ConfigManager.getProperty("url");// 连接URL字符串
	private static String user = ConfigManager.getProperty("user"); // 数据库用户名
	private static String password = ConfigManager.getProperty("password"); // 用户密码

	// private Connection conn;

	/*
	 * static { try { Class.forName(driver); } catch (ClassNotFoundException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	/**
	 * 获取数据库连接对象。
	 */
	public static Connection getConnection() {
		// 获取连接并捕获异常
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;// 返回连接对象
	}

	/*
	 * Connection conn = null; try { Context ctx = new InitialContext();
	 * DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/news"); conn =
	 * ds.getConnection(); } catch (NamingException e) { e.printStackTrace(); }
	 * catch (SQLException e) { e.printStackTrace(); } return conn;// 返回连接对象 }
	 */

	/**
	 * 关闭数据库连接。
	 * 
	 * @param conn
	 *            数据库连接
	 * @param stmt
	 *            Statement对象
	 * @param rs
	 *            结果集
	 */
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// 若结果集对象不为空，则关闭
		try {
			if (rs != null && !rs.isClosed())
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 若Statement对象不为空，则关闭
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 若数据库连接对象不为空，则关闭
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
