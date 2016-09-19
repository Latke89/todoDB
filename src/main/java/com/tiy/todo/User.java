package com.tiy.todo;

import javax.persistence.*;

/**
 * Created by Brett on 9/15/16.
 */

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	int id;

	@Column (nullable = false)
	String password;

	@Column (nullable = false, unique = true)
	String name;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name, String password) {
		this.password = password;
		this.name = name;
	}
}
