package com.team4.bigtower.fileBoard.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface FileBoardService {
	@Transactional
	public int fileBoardAdd(FileBoardCommand fileBoard);

	public List<BoardFilesCommand> getBoardFilesList();
}
