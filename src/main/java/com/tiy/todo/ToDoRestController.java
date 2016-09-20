package com.tiy.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brett on 9/19/16.
 */
@RestController
public class ToDoRestController {

	@Autowired
	ToDoRepository todos;

	@RequestMapping(path = "/todos.json", method = RequestMethod.GET)
	public ArrayList<ToDoItem> getTodos() {
		ArrayList<ToDoItem>todoList = new ArrayList<>();
		Iterable<ToDoItem>allItems = todos.findAll();
		for (ToDoItem item : allItems) {
			todoList.add(item);
		}

		return todoList;
	}

	@RequestMapping(path = "/addTodo.json", method = RequestMethod.POST)
	public List<ToDoItem> addTodo (HttpSession session, @RequestBody ToDoItem item) throws Exception {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			throw new Exception("Cannot create new todo without user logged in");
		}
		item.user = user;
		todos.save(item);
		return getTodos();
	}

}
