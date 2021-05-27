package com.bitcamp.myapp.dao;

import org.apache.ibatis.annotations.Select;

import com.bitcamp.myapp.vo.MemberVO;

public interface MemberDAO {
	// 어노테이션을 이용하여 메소드 정의 전에 쿼리문을 작성한다.					
	@Select("select userid, username from registor where userid=#{userid} and userpwd=#{userpwd}")
	public MemberVO login(MemberVO vo);
}
