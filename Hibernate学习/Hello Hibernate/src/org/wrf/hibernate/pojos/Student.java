package org.wrf.hibernate.pojos;

import java.io.Serializable;

public class Student implements Serializable {
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	//属性
	private String id;
	private String name;
	private int score;
	//属性的getter和setter方法
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
	

}
