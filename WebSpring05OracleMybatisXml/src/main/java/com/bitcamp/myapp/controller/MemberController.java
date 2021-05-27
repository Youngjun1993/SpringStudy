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
	
	//로그인폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "/member/loginForm";
	}
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		//logVo가 null일경우 로그인 실패, null이 아닐경우에는 vo(아이디, 이름)가 리턴된다.
		MemberVO logVo = memberService.loginCheck(vo);
		
		if(logVo != null) { //로그인 성공
			session.setAttribute("logVo", logVo);
			mav.setViewName("redirect:/");
		}else { //로그인 실패
			mav.setViewName("redirect:loginForm");
		}
		return mav;
	}
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
