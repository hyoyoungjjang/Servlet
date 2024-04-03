package com.kh.board.model.vo;

import java.sql.Date;

public class Attachment {
	
	private int fileNo;
	private int refBoeardNo;
	private String originName;
	private String changeName;
	private String filepath;
	private Date uploadDate;
	private int fileLevel;
	private String status;
	
	public Attachment() {
		super();
	}

	public Attachment(int fileNo, int refBoeardNo, String originName, String changeName, String filepath,
			Date uploadDate, int fileLevel, String status) {
		super();
		this.fileNo = fileNo;
		this.refBoeardNo = refBoeardNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filepath = filepath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.status = status;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getRefBoeardNo() {
		return refBoeardNo;
	}

	public void setRefBoeardNo(int refBoeardNo) {
		this.refBoeardNo = refBoeardNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", refBoeardNo=" + refBoeardNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filepath=" + filepath + ", uploadDate=" + uploadDate
				+ ", fileLevel=" + fileLevel + ", status=" + status + "]";
	}
	
	
}
