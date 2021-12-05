package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.CalendarVO;
import org.jobcho.mapper.BoardMapper;
import org.jobcho.mapper.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
@NoArgsConstructor
public class CalendarServiceImpl implements CalendarService{
	
	@Autowired
	private CalendarMapper mapper;
	
	public int insertCalendar(CalendarVO calendar) {
		
		log.info("캘린더 일정 추가 =============" + calendar);
		
		return mapper.insertCalendar(calendar);
	}

	@Override
	public List<CalendarVO> getListCalendar(@RequestParam("method=date") CalendarVO cal_num) {
		
		log.info("캘린더 일정 조회=============" + cal_num);
		
		return mapper.getListCalendar(cal_num);
	}

	@Override
	public int updateCalendar(CalendarVO calendar) {
		
		log.info("캘린더 일정 수정 =============" + calendar);
		
		return mapper.updateCalendar(calendar);
	}

	@Override
	public void deleteCalendar(int cal_num) {

		log.info("캘린더 일정 삭제 =============" + cal_num);
		
		mapper.deleteCalendar(cal_num);
	}
	
}
