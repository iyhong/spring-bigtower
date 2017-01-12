package com.team4.bigtower.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team4.bigtower.member.service.Member;
import com.team4.bigtower.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value="/memberAdd" , method=RequestMethod.GET)
	public String memberAdd(){
		logger.info("memberAdd() GET 호출");
		return "/member/memberAdd";
	}
	
	@RequestMapping(value="/memberAdd", method=RequestMethod.POST)
	public String memberAdd(Member member){
		logger.info("memberAdd() POST 호출");
		logger.info("{}", member);
		memberService.memberAdd(member);
		return "redirect:/memberAdd";
	}
}
