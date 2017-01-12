package com.team4.bigtower.fileBoard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team4.bigtower.HomeController;
import com.team4.bigtower.fileBoard.service.FileBoard;
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
	public String fileBoardAdd(FileBoard fileBoard){
		logger.debug("fileBoardAdd() POST 호출");
		logger.debug("{}",fileBoard);
		int rowCount = fileBoardService.fileBoardAdd(fileBoard);
		if(rowCount > 1){
			logger.debug("삽입 성공");
			logger.debug("실행쿼리row수 :{}",rowCount);
			return "redirect:/fileBoard/fileBoardAdd";
		}
		logger.debug("삽입 실패");
		return "redirect:/fileBoard/fileBoardAdd";
	}
}
