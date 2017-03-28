package com.hpzc.redis.dao;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = -1959528436584592183L;

	private String id;

	private String name;

	public Member() {
	}

	public Member(String id, String name) {
		this.setId(id);
		this.setName(name);
	}

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

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + "]";
	}

}
