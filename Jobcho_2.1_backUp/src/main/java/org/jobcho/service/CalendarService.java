package org.jobcho.service;

import java.util.List;

import org.jobcho.domain.CalendarVO;

public interface CalendarService {
	
	public int insertCalendar(CalendarVO calendar);
	
	public List<CalendarVO> getListCalendar(CalendarVO cal_num);
	
	public int updateCalendar(CalendarVO calendar);
	
	public void deleteCalendar(int cal_num);
	
}
