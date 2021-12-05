package org.jobcho.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jobcho.domain.AccessLogVO;
import org.jobcho.domain.UsageCountVO;

public interface AdminPageMapper {
	List<AccessLogVO> getAdminPageDau(int team_num);
	List<AccessLogVO> getAdminPageMau(int team_num);
	int getAdminPageDauCount(int team_num);
	int getAdminPageMauCount(int team_num);
	UsageCountVO getAdminPageUsagePeriod(Map<String, Object> map);
	UsageCountVO getAdminPageUsageDay(int team_num);
	UsageCountVO getAdminPageUsageMonth(int team_num);
}
