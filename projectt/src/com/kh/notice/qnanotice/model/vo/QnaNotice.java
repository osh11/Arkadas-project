package com.kh.notice.qnanotice.model.vo;

import java.sql.Date;

public class QnaNotice {
	
	private String QNA_COUNT;
	private String QNA_SEQNO;
	private String QNA_TITLE;
	private String QNA_CONTENT;		
	private String QNA_CRT_USER;
	private String QNA_CRT_DATE;
	private String QNA_COMMENT;
	private String QNA_RESP_USER;
	private String QNA_RESP_DATE;
	
	public QnaNotice() {
		
	}
	
	
	public QnaNotice(String QNA_COUNT, String QNA_SEQNO, String QNA_TITLE, String QNA_CONTENT, String QNA_CRT_USER,
			String QNA_CRT_DATE, String QNA_COMMENT, String QNA_RESP_USER, String QNA_RESP_DATE) {
		super();
		this.QNA_COUNT = QNA_COUNT;
		this.QNA_SEQNO = QNA_SEQNO;
		this.QNA_TITLE = QNA_TITLE;
		this.QNA_CONTENT = QNA_CONTENT;
		this.QNA_CRT_USER = QNA_CRT_USER;
		this.QNA_CRT_DATE = QNA_CRT_DATE;
		this.QNA_COMMENT = QNA_COMMENT;
		this.QNA_RESP_USER = QNA_RESP_USER;
		this.QNA_RESP_DATE = QNA_RESP_DATE;
	}


	public String getQNA_COUNT() {
		return QNA_COUNT;
	}


	public void setQNA_COUNT(String qNA_COUNT) {
		QNA_COUNT = qNA_COUNT;
	}


	public String getQNA_SEQNO() {
		return QNA_SEQNO;
	}


	public void setQNA_SEQNO(String qNA_SEQNO) {
		QNA_SEQNO = qNA_SEQNO;
	}


	public String getQNA_TITLE() {
		return QNA_TITLE;
	}


	public void setQNA_TITLE(String qNA_TITLE) {
		QNA_TITLE = qNA_TITLE;
	}


	public String getQNA_CONTENT() {
		return QNA_CONTENT;
	}


	public void setQNA_CONTENT(String qNA_CONTENT) {
		QNA_CONTENT = qNA_CONTENT;
	}


	public String getQNA_CRT_USER() {
		return QNA_CRT_USER;
	}


	public void setQNA_CRT_USER(String qNA_CRT_USER) {
		QNA_CRT_USER = qNA_CRT_USER;
	}


	public String getQNA_CRT_DATE() {
		return QNA_CRT_DATE;
	}


	public void setQNA_CRT_DATE(String qNA_CRT_DATE) {
		QNA_CRT_DATE = qNA_CRT_DATE;
	}


	public String getQNA_COMMENT() {
		return QNA_COMMENT;
	}


	public void setQNA_COMMENT(String qNA_COMMENT) {
		QNA_COMMENT = qNA_COMMENT;
	}


	public String getQNA_RESP_USER() {
		return QNA_RESP_USER;
	}


	public void setQNA_RESP_USER(String qNA_RESP_USER) {
		QNA_RESP_USER = qNA_RESP_USER;
	}


	public String getQNA_RESP_DATE() {
		return QNA_RESP_DATE;
	}


	public void setQNA_RESP_DATE(String qNA_RESP_DATE) {
		QNA_RESP_DATE = qNA_RESP_DATE;
	}


	@Override
	public String toString() {
		return "QnaNotice [QNA_COUNT=" + QNA_COUNT + ", QNA_SEQNO=" + QNA_SEQNO + ", QNA_TITLE=" + QNA_TITLE
				+ ", QNA_CONTENT=" + QNA_CONTENT + ", QNA_CRT_USER=" + QNA_CRT_USER + ", QNA_CRT_DATE=" + QNA_CRT_DATE
				+ ", QNA_COMMENT=" + QNA_COMMENT + ", QNA_RESP_USER=" + QNA_RESP_USER + ", QNA_RESP_DATE="
				+ QNA_RESP_DATE + "]";
	}

}
