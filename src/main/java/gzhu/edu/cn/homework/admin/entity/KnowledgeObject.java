package gzhu.edu.cn.homework.admin.entity;

/**
 * 学习对象
 * 
 * @author dell
 *
 */
public class KnowledgeObject {

	private long id;

	private String name;

	private String description;

	private KnowledgeObject parent;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public KnowledgeObject getParent() {
		return parent;
	}

	public void setParent(KnowledgeObject parent) {
		this.parent = parent;
	}
}
