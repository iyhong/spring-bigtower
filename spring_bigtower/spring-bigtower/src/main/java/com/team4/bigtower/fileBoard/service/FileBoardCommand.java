package com.team4.bigtower.fileBoard.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileBoardCommand {
	private int bNo;
	private String bTitle;
	private String bContent;
	private String mId;
	private String bPw;
	private String bDate;
	private List<MultipartFile> multipartFileList;
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
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getbPw() {
		return bPw;
	}
	public void setbPw(String bPw) {
		this.bPw = bPw;
	}
	public String getbDate() {
		return bDate;
	}
	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	public List<MultipartFile> getMultipartFileList() {
		return multipartFileList;
	}
	public void setMultipartFileList(List<MultipartFile> multipartFileList) {
		this.multipartFileList = multipartFileList;
	}
	@Override
	public String toString() {
		return "FileBoard [bNo=" + bNo + ", bTitle=" + bTitle + ", bContent=" + bContent + ", mId=" + mId + ", bPw="
				+ bPw + ", bDate=" + bDate + ", multipartFileList=" + multipartFileList + "]";
	}

	
}
