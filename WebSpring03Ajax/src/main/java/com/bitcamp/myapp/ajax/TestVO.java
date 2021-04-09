package com.bitcamp.myapp.ajax;

public class TestVO {
	private String num;
	private String name;
	private String id;
	private String tel;
	private String addr;
	
	public TestVO() {}
	public TestVO(String num, String name, String id, String tel, String addr) {
		this.num = num;
		this.name = name;
		this.id = id;
		this.tel = tel;
		this.addr = addr;
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
