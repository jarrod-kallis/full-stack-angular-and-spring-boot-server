package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todoList = new ArrayList<Todo>();
	private static int count = 0;

	static {
		todoList.add(new Todo(++count, "Jarrod", "Learn", new Date(), false));
		todoList.add(new Todo(++count, "Jarrod", "Love", new Date(), false));
		todoList.add(new Todo(++count, "Jarrod", "Dance", new Date(), true));
		todoList.add(new Todo(++count, "Jarrod", "Sew", new Date(), true));
		todoList.add(new Todo(++count, "Jarrod", "Knit", new Date(), true));
		todoList.add(new Todo(++count, "Jarrod", "Fly", new Date(), true));
		todoList.add(new Todo(++count, "Jarrod", "Run", new Date(), false));
	}

	public List<Todo> findAll() {
		return todoList;
	}

	public Todo findById(long id) {
		for (Todo todo : todoList) {
			if (todo.getId() == id) {
				return todo;
			}
		}

		return null;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);

		if (todo != null) {
			todoList.remove(todo);
		}

		return todo;
	}

	public Todo save(Todo todo) {
		Todo tmpTodo = findById(todo.getId());

		if (tmpTodo != null) {
			// update
			int idx = todoList.indexOf(tmpTodo);
			todoList.remove(idx);
			todoList.add(idx, todo);
		} else {
			// insert
			todo.setId(++count);
			todoList.add(todo);
		}

		return todo;
	}
}
