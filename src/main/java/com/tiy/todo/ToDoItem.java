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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean done) {
		isDone = done;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ToDoItem(String text, boolean isDone, User user) {
		this.text = text;
		this.isDone = false;
		this.user = user;
	}
}
