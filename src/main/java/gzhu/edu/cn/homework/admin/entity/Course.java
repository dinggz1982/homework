package gzhu.edu.cn.homework.admin.entity;

public class Course {
	
	private long id;
	
	private String name;
	
	private User teacher;
	
	private ClassInfo classInfo;
	
	private String description;
	
	private MetaCourse metaCourse;

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

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MetaCourse getMetaCourse() {
		return metaCourse;
	}

	public void setMetaCourse(MetaCourse metaCourse) {
		this.metaCourse = metaCourse;
	}
	
	
}
