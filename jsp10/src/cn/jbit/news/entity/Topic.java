package cn.jbit.news.entity;

/**
 * 新闻主题实体类
 * @author Administrator
 *
 */
public class Topic implements java.io.Serializable{

	private static final long serialVersionUID = -7450236550048017952L;
	private int tid;       //新闻主题编号
	private String tname;  //新闻主题名称
	
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
