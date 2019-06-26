package cn.jbit.news.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {

	private static String driver = ConfigManager.getProperty("driver");// ���ݿ������ַ���
	private static String url = ConfigManager.getProperty("url");// ����URL�ַ���
	private static String user = ConfigManager.getProperty("user"); // ���ݿ��û���
	private static String password = ConfigManager.getProperty("password"); // �û�����

	// private Connection conn;

	/*
	 * static { try { Class.forName(driver); } catch (ClassNotFoundException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public static Connection getConnection() {
		// ��ȡ���Ӳ������쳣
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;// �������Ӷ���
	}

	/*
	 * Connection conn = null; try { Context ctx = new InitialContext();
	 * DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/news"); conn =
	 * ds.getConnection(); } catch (NamingException e) { e.printStackTrace(); }
	 * catch (SQLException e) { e.printStackTrace(); } return conn;// �������Ӷ��� }
	 */

	/**
	 * �ر����ݿ����ӡ�
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param stmt
	 *            Statement����
	 * @param rs
	 *            �����
	 */
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		// �����������Ϊ�գ���ر�
		try {
			if (rs != null && !rs.isClosed())
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ��Statement����Ϊ�գ���ر�
		try {
			if (stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �����ݿ����Ӷ���Ϊ�գ���ر�
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
