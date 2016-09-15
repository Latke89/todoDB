package com.tiy.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Brett on 9/15/16.
 */
@Controller
public class ToDoController {
	@Autowired
	ToDoRepository todos;

	@Autowired
	UserRepository users;
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

}
