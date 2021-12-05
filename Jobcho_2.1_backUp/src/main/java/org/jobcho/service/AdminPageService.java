package org.jobcho.service;

import java.util.Date;
import java.util.List;

import org.jobcho.domain.AccessLogVO;
import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsageCountVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.JsonArray;

public interface AdminPageService {
	JsonArray getAdminPageDau(int team_num);
	JsonArray getAdminPageMau(int team_num);
	public ResponseEntity<List<MemberVO>> getAdminPageUsageTopic();
	public ResponseEntity<List<MemberVO>> getAdminPageUsageChat();
	UsageCountVO getAdminPageUsagePeriod(int team_num, String startDate, String endDate);
	UsageCountVO getAdminPageUsageDay(int team_num);
	UsageCountVO getAdminPageUsageMonth(int team_num);
}
