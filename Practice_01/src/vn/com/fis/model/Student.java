package vn.com.fis.model;

import java.util.Date;

public class Student implements Comparable<Student> {
	//properties of Student
	private int code;
	private String name;
	private Date birthDate;
	
	//constructor
	

	public Student(int code, String name, Date birthDate) {
		this.code = code;
		this.name = name;
		this.birthDate = birthDate;
	}


	//setter and getter method
	
	
	public Student() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	//toString method

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", birthDate=" + birthDate + "]";
	}


	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.code - o.getCode();
	}
	
}
