package com.tiy.todo;

import javax.persistence.*;

/**
 * Created by Brett on 9/15/16.
 */

@Entity
@Table(name = "todos")
public class ToDoItem {
	@Id
	@GeneratedValue
	int id;

	@Column (nullable = false)
	String text;

	@Column (nullable = false)
	boolean isDone;

	@ManyToOne
	User user;

	public ToDoItem() {
	}

	public ToDoItem(String text, boolean isDone, User user) {
		this.text = text;
		this.isDone = false;
		this.user = user;
	}
}
