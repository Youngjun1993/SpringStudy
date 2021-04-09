package com.bitcamp.jdbc.member;

public class MemberVO {
	private String userid;
	private String userpwd;
	private String username;

	private int useridCount;
	
	public int getUseridCount() {
		return useridCount;
	}
	public void setUseridCount(int useridCount) {
		this.useridCount = useridCount;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
}

