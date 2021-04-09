package com.bitcamp.home.member;

public interface MemberDAOImpl {
	//로그인
	public void login(MemberVO vo);
	//회원가입
	public int memberInsert(MemberVO vo);
	//회원정보수정
	public int memberUpdate(MemberVO vo);
	//회원선택
	public void memberSelect(MemberVO vo);
}
