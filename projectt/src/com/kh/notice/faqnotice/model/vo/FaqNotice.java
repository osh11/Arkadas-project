package com.kh.notice.faqnotice.model.vo;

import java.sql.Date;

public class FaqNotice {
	
	
	private String FAQ_SEQNO;
	private String FAQ_TITLE;
	private String FAQ_CONTENT;
	private String FAQ_CRT_USER;		
	private String FAQ_CRT_DATE;
	private String FAQ_READ_COUNT;
	
	
	public FaqNotice() {
		
	}
	

	


	public FaqNotice(String fAQ_SEQNO, String fAQ_TITLE, String fAQ_CONTENT, String fAQ_CRT_USER, String fAQ_CRT_DATE,
			String fAQ_READ_COUNT) {
		super();
		FAQ_SEQNO = fAQ_SEQNO;
		FAQ_TITLE = fAQ_TITLE;
		FAQ_CONTENT = fAQ_CONTENT;
		FAQ_CRT_USER = fAQ_CRT_USER;
		FAQ_CRT_DATE = fAQ_CRT_DATE;
		FAQ_READ_COUNT = fAQ_READ_COUNT;
	}

	public FaqNotice(String title, String content, String user) {
		super();
		FAQ_TITLE = title;
		FAQ_CONTENT = content;
		FAQ_CRT_USER = user;
	}
	


	public String getFAQ_SEQNO() {
		return FAQ_SEQNO;
	}





	public void setFAQ_SEQNO(String fAQ_SEQNO) {
		FAQ_SEQNO = fAQ_SEQNO;
	}





	public String getFAQ_TITLE() {
		return FAQ_TITLE;
	}





	public void setFAQ_TITLE(String fAQ_TITLE) {
		FAQ_TITLE = fAQ_TITLE;
	}





	public String getFAQ_CONTENT() {
		return FAQ_CONTENT;
	}





	public void setFAQ_CONTENT(String fAQ_CONTENT) {
		FAQ_CONTENT = fAQ_CONTENT;
	}





	public String getFAQ_CRT_USER() {
		return FAQ_CRT_USER;
	}





	public void setFAQ_CRT_USER(String fAQ_CRT_USER) {
		FAQ_CRT_USER = fAQ_CRT_USER;
	}





	public String getFAQ_CRT_DATE() {
		return FAQ_CRT_DATE;
	}





	public void setFAQ_CRT_DATE(String fAQ_CRT_DATE) {
		FAQ_CRT_DATE = fAQ_CRT_DATE;
	}





	public String getFAQ_READ_COUNT() {
		return FAQ_READ_COUNT;
	}





	public void setFAQ_READ_COUNT(String fAQ_READ_COUNT) {
		FAQ_READ_COUNT = fAQ_READ_COUNT;
	}





	@Override
	public String toString() {
		return "FAQNotice [FAQ_SEQNO=" + FAQ_SEQNO + ", FAQ_TITLE=" + FAQ_TITLE + ", FAQ_CONTENT=" + FAQ_CONTENT
				+ ", FAQ_CRT_USER=" + FAQ_CRT_USER + ", FAQ_READ_COUNT=" + FAQ_READ_COUNT + ", FAQ_CRT_DATE=" + FAQ_CRT_DATE + "]";
	}

}
