package com.bitcamp.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp.service.MemberService;
import com.bitcamp.myapp.vo.MemberVO;

@Controller
public class MemberController {
	@Inject
	MemberService memberService;
	
	@RequestMapping("/loginForm")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping(value="/loginOk", method = RequestMethod.POST)
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		MemberVO logVo = memberService.login(vo);
		ModelAndView mav = new ModelAndView();
		
		if(logVo==null) {
			//로그인 실패
			mav.setViewName("redirect:loginForm");
			logVo.setLogStatus("N");
		}else {
			//로그인 성공
			logVo.setLogStatus("Y");
			session.setAttribute("logId", logVo.getUserid());
			session.setAttribute("logName", logVo.getUsername());
			session.setAttribute("logStatus", logVo.getLogStatus());
			mav.setViewName("home");
		}
		
		return mav;
	}
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
