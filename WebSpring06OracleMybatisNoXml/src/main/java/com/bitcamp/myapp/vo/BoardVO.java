package com.bitcamp.myapp.vo;

import java.util.List;

public class BoardVO {
	private int no;
	private String userid;
	private String subject;
	private String content;
	private int hit;
	private String writedate;
	private String ip;
	
	private String searchKey;
	private String searchWord;
	
	////////////////////////////
	//전체선택한 데이터 넘겨받을 변수
	private int[] noList; //form에서 넘겨받을 name과 동일한 변수명으로 설정
	//private List<Integer> delNoList2; 이것도 가능
	////////////////////////////
	
	public String getSearchKey() {
		return searchKey;
	}
	public int[] getNoList() {
		return noList;
	}
	public void setNoList(int[] noList) {
		this.noList = noList;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
