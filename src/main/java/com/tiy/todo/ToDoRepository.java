package com.tiy.todo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Brett on 9/15/16.
 */
public interface ToDoRepository extends CrudRepository<ToDoItem, Integer> {

}
