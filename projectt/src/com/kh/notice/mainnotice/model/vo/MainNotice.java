package com.kh.notice.mainnotice.model.vo;

import java.sql.Date;

public class MainNotice {
	
	
	private String NOTICE_SEQNO;
	private String NOTICE_TITLE;
	private String NOTICE_CONTENT;
	private String NOTICE_CRT_USER;		
	private String NOTICE_READ_COUNT;
	private String NOTICE_CRT_DATE;
	
	
	public MainNotice() {
		
	}
	

	public MainNotice(String nOTICE_SEQNO, String nOTICE_TITLE, String nOTICE_CONTENT, String nOTICE_CRT_USER,
			String nOTICE_READ_COUNT, String nOTICE_CRT_DATE) {
		super();
		NOTICE_SEQNO = nOTICE_SEQNO;
		NOTICE_TITLE = nOTICE_TITLE;
		NOTICE_CONTENT = nOTICE_CONTENT;
		NOTICE_CRT_USER = nOTICE_CRT_USER;
		NOTICE_READ_COUNT = nOTICE_READ_COUNT;
		NOTICE_CRT_DATE = nOTICE_CRT_DATE;
		
	}

	public MainNotice(String title, String content, String user) {
		super();
		NOTICE_TITLE = title;
		NOTICE_CONTENT = content;
		NOTICE_CRT_USER = user;
	}

	public String getNOTICE_SEQNO() {
		return NOTICE_SEQNO;
	}


	public void setNOTICE_SEQNO(String nOTICE_SEQNO) {
		NOTICE_SEQNO = nOTICE_SEQNO;
	}


	public String getNOTICE_TITLE() {
		return NOTICE_TITLE;
	}


	public void setNOTICE_TITLE(String nOTICE_TITLE) {
		NOTICE_TITLE = nOTICE_TITLE;
	}


	public String getNOTICE_CONTENT() {
		return NOTICE_CONTENT;
	}


	public void setNOTICE_CONTENT(String nOTICE_CONTENT) {
		NOTICE_CONTENT = nOTICE_CONTENT;
	}


	public String getNOTICE_CRT_USER() {
		return NOTICE_CRT_USER;
	}


	public void setNOTICE_CRT_USER(String nOTICE_CRT_USER) {
		NOTICE_CRT_USER = nOTICE_CRT_USER;
	}


	public String getNOTICE_READ_COUNT() {
		return NOTICE_READ_COUNT;
	}


	public void setNOTICE_READ_COUNT(String nOTICE_READ_COUNT) {
		NOTICE_READ_COUNT = nOTICE_READ_COUNT;
	}


	public String getNOTICE_CRT_DATE() {
		return NOTICE_CRT_DATE;
	}


	public void setNOTICE_CRT_DATE(String nOTICE_CRT_DATE) {
		NOTICE_CRT_DATE = nOTICE_CRT_DATE;
	}


	@Override
	public String toString() {
		return "MainNotice [NOTICE_SEQNO=" + NOTICE_SEQNO + ", NOTICE_TITLE=" + NOTICE_TITLE + ", NOTICE_CONTENT=" + NOTICE_CONTENT
				+ ", NOTICE_CRT_USER=" + NOTICE_CRT_USER + ", NOTICE_READ_COUNT=" + NOTICE_READ_COUNT + ", NOTICE_CRT_DATE=" + NOTICE_CRT_DATE + "]";
	}

}
