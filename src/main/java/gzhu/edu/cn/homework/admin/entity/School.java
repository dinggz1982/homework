package gzhu.edu.cn.homework.admin.entity;

public class School {
	
	/**
	 * 构造方法
	 */
	public School() {
		
	}
	
	public School(String name,String address,String tel) {
		this.id= id;
		this.name = name;
		this.address = address;
		this.tel = tel;
	}
	
	private int id;
	
	private String name;
	
	private String address;
	
	private String tel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
