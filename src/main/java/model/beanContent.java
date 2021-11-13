package model;

/*import java.util.ArrayList;
import java.util.Date;
import java.util.List;*/

public class beanContent {
	private int id;
	private String title;
	private String brief;
	private String content;
	private int authorid;
	private boolean draft;
	private String createdate;
	private String updatetime;

	
	public beanContent() {
	}

	public beanContent(int id, String title, String brief, String content, String updatetime) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.updatetime = updatetime;
	}

	public beanContent(int id, String title, String brief, String createdate) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.createdate = createdate;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getBrief() {
		return brief;
	}



	public void setBrief(String brief) {
		this.brief = brief;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getAuthorid() {
		return authorid;
	}



	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}



	public boolean isDraft() {
		return draft;
	}



	public void setDraft(boolean draft) {
		this.draft = draft;
	}



	public String getCreatedate() {
		return createdate;
	}



	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}



	public String getUpdatetime() {
		return updatetime;
	}



	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	


}
