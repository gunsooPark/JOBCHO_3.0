package org.jobcho.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jobcho.domain.TodoVO;
import org.jobcho.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team/{team_num}/todo")
public class TodoController {

	@Autowired
	TodoService service;

	// 오늘의 할일 생성 -> postMan 확인완료
	// team_num필요
	@PostMapping("/new")
	public ResponseEntity<Integer> insertTodo(@PathVariable("team_num") int team_num, @RequestBody TodoVO todo) {
		System.out.println("todo객체" + todo);
		System.out.println("team_num" + team_num);
		int re = service.insertTodo(todo);

		return new ResponseEntity<Integer>(re, HttpStatus.OK);
	}

	// 할일 정보 반환 -> 1개 -> postMan 확인완료 -> json으로 반환함
	// team_num필요
	@GetMapping(value = "/{todo_num}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<TodoVO> getTodo(@PathVariable("team_num") int team_num,
			@PathVariable("todo_num") int todo_num) {
		TodoVO todo = service.getTodo(todo_num);

		return new ResponseEntity<TodoVO>(todo, HttpStatus.OK);
	}

	//팀번호와 해당하는 member에 맞는 리스트반환 -> postMan확인완료 -> json으로 반환함
	// team_num, member_num 필요
	@GetMapping(value = "/list/{member_num}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<TodoVO>> selectTodoList2(@PathVariable("team_num") int team_num,
			@PathVariable("member_num") int member_num) {
		System.out.println("팀넘버 : " + team_num);
		System.out.println("멤버넘 : " + member_num);
		// List<TodoVO> list = service.selectTodoList();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("team_num", team_num);
		map.put("member_num", member_num);

		List<TodoVO> list = service.selectTodoList2(map);

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 팀번호에 맞는 할일 리스트 반환 -> postMan확인완료 -> json으로 반환함
	// team_num필요
	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<TodoVO>> selectTodoList(@PathVariable("team_num") int team_num) {

		List<TodoVO> list = service.selectTodoList();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// 오늘의 할일 수정 -> postMan 확인완료
	// team_num필요
	@PutMapping("/{todo_num}")
	public ResponseEntity<Integer> updateTodo(@PathVariable("team_num") int team_num,
			@PathVariable("todo_num") int todo_num, @RequestBody TodoVO todo) {

		int re = service.updateTodo(todo);

		return new ResponseEntity<Integer>(re, HttpStatus.OK);
	}

	// 오늘의 할 일 삭제 -> postMan 확인완료
	// team_num필요
	@DeleteMapping("/{todo_num}")
	public ResponseEntity<Integer> deleteTodo(@PathVariable("team_num") int team_num,
			@PathVariable("todo_num") int todo_num) {

		int re = service.deleteTodo(todo_num);

		return new ResponseEntity<Integer>(re, HttpStatus.OK);

	}

}
