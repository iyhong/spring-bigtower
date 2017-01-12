package com.team4.bigtower.fileBoard.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FileBoardService {
	public int fileBoardAdd(FileBoard fileBoard);
}
