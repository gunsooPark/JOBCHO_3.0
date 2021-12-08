package org.jobcho.service;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.TodoVO;

public interface TodoService {
	public int insertTodo(TodoVO todo);
	public TodoVO getTodo(int todo_num);
	public List<TodoVO> selectTodoList();
	public int updateTodo(TodoVO todo);
	public int deleteTodo(int todo_num);
	public List<TodoVO> selectTodoList2(Map<String, Integer> map);
	public List<TodoVO> selectTodoDeleteList(Map<String, Integer> map);
	public int restoreTodoList(int todo_num);
}
