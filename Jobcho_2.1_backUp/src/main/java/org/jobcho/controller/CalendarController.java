package org.jobcho.controller;

import java.util.List;


import org.jobcho.domain.CalendarVO;
import org.jobcho.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/team/{team_num}/calendar")
@Log4j
public class CalendarController {
	@Autowired
	private CalendarService service;
	
	//¿Ã∫•∆Æ ª˝º∫
	@RequestMapping(value="/new", method = {RequestMethod.POST})
	
	public ResponseEntity<CalendarVO> insertCalendar(@RequestBody CalendarVO calendar,
												@PathVariable("team_num") int team_num
																				){
		log.info("insertCalendar ==================" + calendar);
		int insertCount = service.insertCalendar(calendar);
		
		return insertCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//¿Ã∫•∆Æ ∫“∑Øø¿±‚
	@GetMapping(value = "/getListCalendar",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<CalendarVO>> getListCalendar(CalendarVO cal_num,
															@PathVariable("team_num") int team_num){
		log.info("getListCalendar ================== " + cal_num);
		return new ResponseEntity<>(service.getListCalendar(cal_num), HttpStatus.OK);
	}
	
	//ÔøΩÎ£∑ÔøΩÎí™ÔøΩÎìÉÔßçÔøΩ o
	@PutMapping(value = "/{cal_num}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CalendarVO> updateCalendar(@PathVariable("cal_num") int cal_num,
																				@RequestBody CalendarVO calendar){
		log.info("putMapping ==================" + cal_num);
		
		calendar.setCal_num(cal_num);
		int updateCount = service.updateCalendar(calendar);
		
		return  updateCount == 1
				? new ResponseEntity<>(HttpStatus.OK)
				:  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//ÔøΩÎ£∑ÔøΩÎí™ÔøΩÎìÉÔßçÔøΩ o
	@DeleteMapping(value = "/{cal_num}",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteCalendar(@PathVariable int cal_num){
		
		log.info("DeleteMapping ==================" + cal_num);
		service.deleteCalendar(cal_num);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
