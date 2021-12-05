package org.jobcho.mapper;

import java.util.List;

import org.jobcho.domain.CalendarVO;

public interface CalendarMapper {
	
	int insertCalendar(CalendarVO calendar);
	List<CalendarVO> getListCalendar(CalendarVO cal_num);
	int updateCalendar(CalendarVO calendar);
	void deleteCalendar(int cal_num);

	
}
