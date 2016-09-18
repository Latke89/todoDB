package com.tiy.todo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Brett on 9/15/16.
 */
public interface ToDoRepository extends CrudRepository<ToDoItem, Integer> {

//	@Query("SELECT todo FROM ToDoItem todo ORDER BY todo.id WHERE todo.id = ?")
	List<ToDoItem> findByUser(User user);
	List<ToDoItem> findByisDoneFalse(User user);

}
