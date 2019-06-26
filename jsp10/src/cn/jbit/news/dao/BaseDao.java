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
 * 数据库连接与关闭工具类。
 * 
 * @author 北大青鸟
 */
public class BaseDao {
   /* private static String driver = ConfigManager.getProperty("driver");// 数据库驱动字符串
    private static String url = ConfigManager.getProperty("url");// 连接URL字符串
    private static String user = ConfigManager.getProperty("user"); // 数据库用户名
    private static String password = ConfigManager.getProperty("password"); // 用户密码
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
     * 获取数据库连接对象。
     */
    public Connection getConnection() {
        // 获取连接并捕获异常
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
        return conn;// 返回连接对象
    }

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
    public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
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

    /**
     * 增、删、改操作
     * 
     * @param sql
     *            sql语句
     * @param prams
     *            参数数组
     * @return 执行结果
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
     * 查询操作
     * 
     * @param sql
     *            sql语句
     * @param params
     *            参数数组
     * @return 查询结果集
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
