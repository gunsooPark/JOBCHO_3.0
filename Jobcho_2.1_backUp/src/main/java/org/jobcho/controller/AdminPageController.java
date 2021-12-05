package org.jobcho.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.jobcho.domain.AccessLogVO;
import org.jobcho.domain.MemberVO;
import org.jobcho.domain.UsageCountVO;
import org.jobcho.mapper.MemberMapper;
import org.jobcho.service.AdminPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/team/{team_num}/admin")
public class AdminPageController {
	
	@Autowired
	AdminPageService service;
	
	
	@GetMapping("/dau")
	public ResponseEntity<String> getAdminPageDau(@PathVariable int team_num){
		JsonArray list = service.getAdminPageDau(team_num);
		return new ResponseEntity<>(list.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/mau")
	public ResponseEntity<String> getAdminPageMau(@PathVariable int team_num){
		JsonArray list = service.getAdminPageMau(team_num);
		return new ResponseEntity<>(list.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/usage/day")
	public ResponseEntity<UsageCountVO> getAdminPageUsageDay(@PathVariable int team_num){
		UsageCountVO usageCount = service.getAdminPageUsageDay(team_num);
		return new ResponseEntity<>(usageCount, HttpStatus.OK);
	}
	
	@GetMapping("/usage/month")
	public ResponseEntity<UsageCountVO> getAdminPageUsageMonth(@PathVariable int team_num){
		UsageCountVO usageCount = service.getAdminPageUsageMonth(team_num);
		return new ResponseEntity<>(usageCount, HttpStatus.OK);
	}
	
	@GetMapping("/usage/period")
	public ResponseEntity<UsageCountVO> getAdminPageUsagePeriod(
			@PathVariable("team_num") int team_num, @RequestBody HashMap<String, Object> period 
			){
		System.out.println(period);
		String startDate = (String)period.get("startdate");
		String endDate = (String)period.get("enddate");
		if(startDate==null || endDate ==null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UsageCountVO usageCount = service.getAdminPageUsagePeriod(team_num, startDate, endDate);
		return new ResponseEntity<>(usageCount, HttpStatus.OK);
	}
	
//	@GetMapping("/usage/topic")
//	public ResponseEntity<List<MemberVO>> getAdminPageUsageTopic(){
//		return null;
//	}
//	
//	@GetMapping("/usage/chat")
//	public ResponseEntity<List<MemberVO>> getAdminPageUsageChat(){
//		return null;
//	}
	
	
	
}
