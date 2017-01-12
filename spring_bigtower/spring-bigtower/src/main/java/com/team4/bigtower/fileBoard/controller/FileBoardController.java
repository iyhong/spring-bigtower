package com.team4.bigtower.fileBoard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team4.bigtower.HomeController;
import com.team4.bigtower.fileBoard.service.FileBoardCommand;
import com.team4.bigtower.fileBoard.service.FileBoardService;

@Controller
public class FileBoardController {
	@Autowired
	private FileBoardService fileBoardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/fileBoardAdd",method=RequestMethod.GET)
	public String fileBoardAdd(){
		logger.debug("fileBoardAdd() GET 호출");
		return "/fileBoard/fileBoardAdd";
	}
	
	@RequestMapping(value="/fileBoardAdd",method=RequestMethod.POST)
	public String fileBoardAdd(FileBoardCommand fileBoardCommand){
		logger.debug("fileBoardAdd() POST 호출");
		logger.debug("{}",fileBoardCommand);
		int rowCount = fileBoardService.fileBoardAdd(fileBoardCommand);
		if(rowCount > 1){
			logger.debug("삽입 성공");
			logger.debug("실행쿼리row수 :{}",rowCount);
			return "redirect:/fileBoard/fileBoardAdd";
		}
		logger.debug("삽입 실패");
		return "redirect:/fileBoard/fileBoardAdd";
	}
	@RequestMapping(value="/fileBoardList",method=RequestMethod.GET)
	public String fileBoardList(){
		logger.debug("fileBoardList() GET ");
		fileBoardService.get
		
		return "/fileBoard/fileBoardList";
	}
}
