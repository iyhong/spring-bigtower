package com.team4.bigtower.fileBoard.service;

import java.util.List;

public class BoardFilesCommand {
	private int bNo;
	private String bTitle;
	private String bContent;
	private String bDate;
	private List<Files> filesList;
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public List<Files> getFilesList() {
		return filesList;
	}
	public void setFilesList(List<Files> filesList) {
		this.filesList = filesList;
	}
	@Override
	public String toString() {
		return "BoardFilesCommand [bNo=" + bNo + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bDate=" + bDate
				+ ", filesList=" + filesList + "]";
	}
	
	
	
	
}
