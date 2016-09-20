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
		Iterable<ToDoItem>allItems = todos.findAllByOrderById();
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

	@RequestMapping(path = "/delete.json", method = RequestMethod.GET)
	public List<ToDoItem> deleteTodo(int todoID) throws Exception {
		ToDoItem item = todos.findOne(todoID);

		todos.delete(item.id);
		return getTodos();
	}

	@RequestMapping(path = "/toggle.json", method = RequestMethod.GET)
	public List<ToDoItem> toggleTodo(int todoID) {
		System.out.println("Toggling todo with ID " + todoID);

		ToDoItem item = todos.findOne(todoID);
		item.isDone = !item.isDone;
		todos.save(item);

		return getTodos();
	}

}
