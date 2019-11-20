package gzhu.edu.cn.homework.admin.entity;
/**
 * 教材
 * @author dinggz
 * @date 2019年11月21日 上午12:28:23
 */
public class Textbook {
	
	private long id;
	
	private String press;
	
	private String isbn;
	
	private String name;
	
	private Course course;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

}
