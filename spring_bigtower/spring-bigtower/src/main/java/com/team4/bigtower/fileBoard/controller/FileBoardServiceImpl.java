package com.team4.bigtower.fileBoard.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.team4.bigtower.fileBoard.service.Board;
import com.team4.bigtower.fileBoard.service.BoardFilesCommand;
import com.team4.bigtower.fileBoard.service.FileBoardCommand;
import com.team4.bigtower.fileBoard.service.FileBoardService;
import com.team4.bigtower.fileBoard.service.Files;

@Service
public class FileBoardServiceImpl implements FileBoardService{
	@Autowired
	private FileBoardDao fileBoardDao;
	private static final Logger logger = LoggerFactory.getLogger(FileBoardServiceImpl.class);

	@Transactional
	public int fileBoardAdd(FileBoardCommand fileBoard){
		File destFile = null;
		int rowCount = 0;
		try {
			Board board = new Board();
			Files files = new Files();
			//String path= "D:/honginyong/workspace_sts/git/spring-bigtower/spring-bigtower/spring_bigtower/spring-bigtower/src/main/resources/upload/";
			//String path = "/Users/hong-in-yong/Documents/workspace_sts/git/spring-mvc-bigtower/spring-bigtower/spring_bigtower/spring-bigtower/src/main/resources/upload/";
			String path = "D:\\apache-tomcat-8.5.9\\webapps\\spring-bigtower\\resources\\";
			//conn.setAutoCommit(false);
			board.setbTitle(fileBoard.getbTitle());
			board.setbContent(fileBoard.getbContent());
			board.setmId(fileBoard.getmId());
			board.setbPw(fileBoard.getbPw());
			rowCount = fileBoardDao.boardInsert(board);
			logger.debug("board:{}",board);

			boolean flag = true;
			if(flag){
				throw new RuntimeException();
				
			}
			
			List<MultipartFile> multipartFileList = fileBoard.getMultipartFileList();
			logger.debug("파일사이즈 : {}",multipartFileList.size());
			for(int i= 0; i<multipartFileList.size();i++){
				int index = multipartFileList.get(i).getOriginalFilename().lastIndexOf(".");
				logger.debug("{}", index);
				String extention = multipartFileList.get(i).getOriginalFilename().substring(index);
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString().replace("-", "");
				fileName += extention;
				
				files.setfName(fileName);
				files.setfPath(path);
				files.setbNo(board.getbNo());
				rowCount += fileBoardDao.fileInsert(files);
				
				destFile = new File(path+fileName);
				multipartFileList.get(i).transferTo(destFile);
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("Exception 예외발생!!");
			e.printStackTrace();
		//	logger.debug("{}",destFile.exists());
			//if(destFile.exists()) {
				
				destFile.delete();
				logger.debug("destFile delete");
			//}
		} 
		
		return rowCount;
	}
	
	public List<BoardFilesCommand> getBoardFilesList(){
		
		List<BoardFilesCommand> boardFilesList= fileBoardDao.boardAllSelect();
		for(int i=0; i<boardFilesList.size();i++){
			int bNo = boardFilesList.get(i).getbNo();
			boardFilesList.get(i).setFilesList(fileBoardDao.fileListSelect(bNo));
		}
		
		return boardFilesList;
	}
	
}
