package com.tiy.todo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Brett on 9/15/16.
 */
public interface ToDoRepository extends CrudRepository<ToDoItem, Integer> {

	List<ToDoItem> findByUser(User user);
	List<ToDoItem> findByUserOrderById(User user);
	List<ToDoItem> findAllByOrderById();

}
