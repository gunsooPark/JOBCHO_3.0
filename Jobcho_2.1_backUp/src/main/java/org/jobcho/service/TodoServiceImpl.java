package org.jobcho.service;

import java.util.List;
import java.util.Map;

import org.jobcho.domain.TodoVO;
import org.jobcho.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoMapper mapper;
	
	//오늘의 할일 생성 
	@Override
	public int insertTodo(TodoVO todo) {
		int re = mapper.insertTodo(todo);
		return re;
	}

	//할일 정보반환 
	@Override
	public TodoVO getTodo(int todo_num) {
		TodoVO todo = mapper.getTodo(todo_num);
		return todo;
	}
	
	//할일 리스트 정보 변환 
	@Override
	public List<TodoVO> selectTodoList() {
		List<TodoVO> todoList = mapper.selectTodoList();
		return todoList;
	}

	//할일 수정 
	@Override
	public int updateTodo(TodoVO todo) {
		int re = mapper.updateTodo(todo);
		return re;
	}

	//할일 삭제 -> islive를 0으로 변경 
	@Override
	public int deleteTodo(int todo_num) {
		int re = mapper.deleteTodo(todo_num);
		return re;
	}

	//할일리스트 두번째 방법
	@Override
	public List<TodoVO> selectTodoList2(Map<String, Integer> map) {
		List<TodoVO> todoList = mapper.selectTodoList2(map);
		return todoList;
	}

}
