package com.bitcamp.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	public JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	//HomeController 클래스가 호출될때 아래 메소드는 자동실행되며 매개변수명을 servlet-context.xml에서 같은 변수명아 담아준다.(Autowired의 기능)
	@Autowired
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
		Constants.jdbcTemplate = template;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
}
