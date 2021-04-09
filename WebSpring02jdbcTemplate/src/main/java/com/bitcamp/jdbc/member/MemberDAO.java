package com.bitcamp.jdbc.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.jdbc.Constants;

public class MemberDAO {
	public JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public MemberDAO() {
		template = Constants.jdbcTemplate;
	}
	
	//로그인
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "select count(userid) useridCount from registor where userid=? and userpwd=?";
		
		//					** select한 필드명과 VO에 있는 변수명이 같으면 set해준다. **
		MemberVO vo2 = template.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class), vo.getUserid(), vo.getUserpwd());
		
		if(vo2.getUseridCount()>0) {//아이디가 존재한다.
			//아이디와 이름을 선택하여 vo리턴
			
			sql="select userid, username from registor where userid=? and userpwd=?";
			return template.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(MemberVO.class), vo.getUserid(), vo.getUserpwd());
			
		}else{//아이디가 존재하지 않는다.
			return null;
		}
	}
	
}	
