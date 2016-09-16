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

	public String getPassword() {
		return password;
	}

	public User(String name, String password) {
		this.password = password;
		this.name = name;
	}
}
