package com.tiy.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Brett on 9/19/16.
 */
@RestController
public class ToDoRestController {

	@Autowired
	ToDoRepository todos;

	@RequestMapping(path = "todos.json", method = RequestMethod.GET)
	public ArrayList<ToDoItem> todosJSON() {
		ArrayList<ToDoItem>todoList = new ArrayList<>();
		Iterable<ToDoItem>allItems = todos.findAll();
		for (ToDoItem item : allItems) {
			todoList.add(item);
		}

		return todoList;
	}

}
