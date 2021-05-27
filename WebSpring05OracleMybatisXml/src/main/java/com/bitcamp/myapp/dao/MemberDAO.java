package com.bitcamp.myapp.dao;

import com.bitcamp.myapp.vo.MemberVO;

public interface MemberDAO {
	//로그인
	public MemberVO loginCheck(MemberVO vo);
}
