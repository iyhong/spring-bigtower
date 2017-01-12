package com.team4.bigtower.fileBoard.controller;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.team4.bigtower.fileBoard.service.Board;
import com.team4.bigtower.fileBoard.service.BoardFilesCommand;
import com.team4.bigtower.fileBoard.service.Files;

@Repository
public class FileBoardDao {
	@Autowired
	private SqlSessionTemplate sql;
	private static final Logger logger = LoggerFactory.getLogger(FileBoardDao.class);

	public int boardInsert(Board board){
		return sql.insert("FileBoard.boardAdd",board);
	}
	public int fileInsert(Files files){
		return sql.insert("FileBoard.fileAdd", files);
	}
	public List<BoardFilesCommand> boardAllSelect(){
		return sql.selectList("FileBoard.boardList");
	}
	public List<Files> fileListSelect(int bNo){
		return sql.selectList("FileBoard.fileList",bNo);
	}
	
}
