package gzhu.edu.cn.homework.admin.entity;
/**
 * 教材大纲
 * @author dinggz
 * @date 2019年11月21日 上午12:31:24
 */
public class OutLine {
	
	private long id;
	
	private String name;
	
	private OutLine parent;
	
	private String description;
	
	private Textbook textbook;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OutLine getParent() {
		return parent;
	}

	public void setParent(OutLine parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Textbook getTextbook() {
		return textbook;
	}

	public void setTextbook(Textbook textbook) {
		this.textbook = textbook;
	}
	
}
