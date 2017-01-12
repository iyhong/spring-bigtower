package com.team4.bigtower.fileBoard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team4.bigtower.HomeController;
import com.team4.bigtower.fileBoard.service.BoardFilesCommand;
import com.team4.bigtower.fileBoard.service.FileBoardCommand;
import com.team4.bigtower.fileBoard.service.FileBoardService;

@Controller
public class FileBoardController {
	@Autowired
	private FileBoardService fileBoardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/fileBoardAdd",method=RequestMethod.GET)
	public String fileBoardAdd(){
		logger.debug("fileBoardAdd() GET �샇異�");
		return "/fileBoard/fileBoardAdd";
	}
	
	@RequestMapping(value="/fileBoardAdd",method=RequestMethod.POST)
	public String fileBoardAdd(FileBoardCommand fileBoardCommand){
		logger.debug("fileBoardAdd() POST �샇異�");
		logger.debug("{}",fileBoardCommand);
		int rowCount = fileBoardService.fileBoardAdd(fileBoardCommand);
		if(rowCount > 1){
			logger.debug("�궫�엯 �꽦怨�");
			logger.debug("�떎�뻾荑쇰━row�닔 :{}",rowCount);
			return "redirect:/fileBoardList";
		}
		logger.debug("�궫�엯 �떎�뙣");
		return "redirect:/fileBoard/fileBoardAdd";
	}
	@RequestMapping(value="/fileBoardList",method=RequestMethod.GET)
	public String fileBoardList(Model model){
		logger.debug("fileBoardList() GET ");
		List<BoardFilesCommand> boardFilesList= fileBoardService.getBoardFilesList();
		logger.debug("{}",boardFilesList);
		model.addAttribute("boardFilesList",boardFilesList);
		return "/fileBoard/fileBoardList";
	}
	
	//http://winmargo.tistory.com/103
}
