package cn.jbit.news.entity;

/**
 * ��������ʵ����
 * @author Administrator
 *
 */
public class Topic implements java.io.Serializable{

	private static final long serialVersionUID = -7450236550048017952L;
	private int tid;       //����������
	private String tname;  //������������
	
	public Topic(){
		
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
}
