package cn.jbit.news.entity;

/**
 * �û���
 * @author Administrator
 *
 */
public class NewsUsers implements java.io.Serializable {
	/**
	 * ���л��汾ID
	 */
	private static final long serialVersionUID = -4727971011310854434L;
	private int uid;
	private String uname;
	private String upwd;
	
	public NewsUsers(){
		
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
}
