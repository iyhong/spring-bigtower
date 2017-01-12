package com.team4.bigtower.fileBoard.controller;

import java.io.File;
import java.io.IOException;
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
import com.team4.bigtower.fileBoard.service.FileBoard;
import com.team4.bigtower.fileBoard.service.Files;

@Service
public class FileBoardService {
	@Autowired
	private FileBoardDao fileBoardDao;
	private static final Logger logger = LoggerFactory.getLogger(FileBoardService.class);

	@Transactional
	public int fileBoardAdd(FileBoard fileBoard){
		File destFile = null;
		int rowCount = 0;
		try {
			Board board = new Board();
			Files files = new Files();
			String path = "D:/jjdev/workspace_sts/git/spring_bigtower/spring-bigtower/src/main/resources/upload/";
			//conn.setAutoCommit(false);
			board.setbTitle(fileBoard.getbTitle());
			board.setbContent(fileBoard.getbContent());
			board.setmId(fileBoard.getmId());
			board.setbPw(fileBoard.getbPw());
			rowCount = fileBoardDao.boardInsert(board);
			logger.debug("board:{}",board);

			List<MultipartFile> multipartFileList = fileBoard.getMultipartFileList();
			for(int i= 0; i<multipartFileList.size();i++){
				int index = multipartFileList.get(i).getOriginalFilename().indexOf(".");
				String extention = multipartFileList.get(i).getOriginalFilename().substring(index);
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString().replace("-", "");
				fileName += extention;
				destFile = new File(path+fileName);
				multipartFileList.get(i).transferTo(destFile);
				//files.setfName(fileName);
				files.setfPath(path);
				files.setbNo(board.getbNo());
				rowCount += fileBoardDao.fileInsert(files);
			}
			
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			destFile.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			destFile.delete();
		} 
		
		return rowCount;
	}
	
}
