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
	String fullName;

	@Column (nullable = false)
	String userName;

	public User() {
	}

	public User(int id, String fullName, String userName) {
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
	}
}
