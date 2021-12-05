package org.jobcho.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jobcho.domain.AccessLogVO;
import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsageCountVO;
import org.jobcho.mapper.AdminPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class AdminPageServiceImpl implements AdminPageService{
	
	@Autowired
	AdminPageMapper mapper;
	
	@Override
	public JsonArray getAdminPageDau(int team_num) {
		List<AccessLogVO> list = mapper.getAdminPageDau(team_num);
		Gson gson = new Gson();
		String jsonListStr = gson.toJson(list);
		JsonParser parser = new JsonParser();
		JsonArray jsonList = (JsonArray)parser.parse(jsonListStr);
		int count = mapper.getAdminPageDauCount(team_num);		
		JsonObject dauCount = new JsonObject();
		dauCount.addProperty("dauCount", count);
		JsonArray jsonarray = new JsonArray();
		jsonarray.add(dauCount);
		jsonarray.add(jsonList);
		return jsonarray;
	}

	@Override
	public JsonArray getAdminPageMau(int team_num) {
		List<AccessLogVO> list = mapper.getAdminPageMau(team_num);		
		Gson gson = new Gson();
		String jsonListStr = gson.toJson(list);
		JsonParser parser = new JsonParser();
		JsonArray jsonList = (JsonArray)parser.parse(jsonListStr);	
		int count = mapper.getAdminPageMauCount(team_num);	
		JsonObject mauCount = new JsonObject();
		mauCount.addProperty("mauCount", count);
		JsonArray jsonarray = new JsonArray();
		jsonarray.add(mauCount);
		jsonarray.add(jsonList);
		return jsonarray;
	}
	
	@Override
	public UsageCountVO getAdminPageUsageDay(int team_num) {
		UsageCountVO usageCount =mapper.getAdminPageUsageDay(team_num);
		return usageCount;
	}

	@Override
	public UsageCountVO getAdminPageUsageMonth(int team_num) {
		UsageCountVO usageCount =mapper.getAdminPageUsageMonth(team_num);
		return usageCount;
	}
	
	@Override
	public UsageCountVO getAdminPageUsagePeriod(
			int team_num, String startform,String endform) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startform);
		map.put("endDate", endform);
		map.put("team_num", team_num);
		UsageCountVO usageCount =mapper.getAdminPageUsagePeriod(map);
		return usageCount;
	}

	@Override
	public ResponseEntity<List<MemberVO>> getAdminPageUsageTopic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<MemberVO>> getAdminPageUsageChat() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
