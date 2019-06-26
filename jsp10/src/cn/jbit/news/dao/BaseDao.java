package cn.jbit.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * ���ݿ�������رչ����ࡣ
 * 
 * @author ��������
 */
public class BaseDao {
   /* private static String driver = ConfigManager.getProperty("driver");// ���ݿ������ַ���
    private static String url = ConfigManager.getProperty("url");// ����URL�ַ���
    private static String user = ConfigManager.getProperty("user"); // ���ݿ��û���
    private static String password = ConfigManager.getProperty("password"); // �û�����
*/
	public BaseDao(){
		
	}
	
	public BaseDao(Connection conn){
		this.conn = conn;
	}
    protected Connection conn;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;
   /* static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/

    /**
     * ��ȡ���ݿ����Ӷ���
     */
    public Connection getConnection() {
        // ��ȡ���Ӳ������쳣
       /* try {
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    	Connection conn = null;
    	try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/news");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;// �������Ӷ���
    }

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
    public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
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

    /**
     * ����ɾ���Ĳ���
     * 
     * @param sql
     *            sql���
     * @param prams
     *            ��������
     * @return ִ�н��
     */
    protected int executeUpdate(String sql, Object... params) {
        int result = 0;
        conn = this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, pstmt, null);
        }
        return result;
    }

    /**
     * ��ѯ����
     * 
     * @param sql
     *            sql���
     * @param params
     *            ��������
     * @return ��ѯ�����
     */
    protected ResultSet executeQuery(String sql, Object... params) {
        conn = this.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
