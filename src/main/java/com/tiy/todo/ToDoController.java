package com.tiy.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

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
	public String home(Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
		}
		return "home";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, String userName, String password) throws Exception {
		User user = users.findFirstByName(userName);
		if (user == null) {
			throw new Exception("user does not exist");
		} else if (!password.equals(user.getPassword())) {
			throw new Exception("Incorrect password");
		}
		session.setAttribute("user", user);
		return "redirect:/";
	}

	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(path = "/newUser", method = RequestMethod.POST)
	public String newUser(HttpSession session, String userName, String password) throws Exception {
		User user = users.findFirstByName(userName);
		if (user == null) {
			user = new User(userName, password);
			users.save(user);
		}
		return "redirect:/";
	}

	@RequestMapping(path = "submitTodo", method = RequestMethod.POST)
	public String insertTodo(HttpSession session, String text, boolean isDone) throws Exception {
		User user = (User) session.getAttribute("user");
		ToDoItem item = new ToDoItem(text, isDone);
		return "redirect:/";
	}



}
