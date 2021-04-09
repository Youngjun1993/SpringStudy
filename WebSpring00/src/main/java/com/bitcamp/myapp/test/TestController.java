package com.bitcamp.myapp.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 선언
@Controller
public class TestController {
	// 리퀘스트맵핑(aLink에 대한)
	@RequestMapping(value="/aLink", method = RequestMethod.GET)
	public String test(HttpServletRequest req, Model model) {
		//클라이언트에서 서버로 데이터 가져오기
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println(name+", "+age);
		
		//Model객체 데이터를 셋팅하면 뷰에서 사용할 수 있다.
		model.addAttribute("username", name);
		model.addAttribute("age", age);
		//서버에 출력
		model.addAttribute("msg", "서버에서 클라이언트에게 데이터 보내기");
		
		//aLink의 맵핑주소로 이동되면 해당 영역이 실행된다.
		
		//.jsp는 안써도 된다.(servlet-context.xml에서 잡아준다)
		return "mappingTest/aLinkView";
	}
	
	//위와 다른방법의 맵핑 (get방식일때 가능한 방식)
	@RequestMapping("/aLink2")
	//@RequestParam : 클라이언트 측 데이터를 서버로 request한다.
	public String test2(@RequestParam("name") String username, @RequestParam("age") int age, Model model) {
		System.out.println("aLink2-->"+username+":"+age);
		
		model.addAttribute("username", username);
		model.addAttribute("age", age);
		model.addAttribute("msg", "@RequestParam을 이용한 데이터 처리");
		
		return "mappingTest/aLinkView";
	}
	
	@RequestMapping("/aLink3") //vo에서 request하여 변수명이 같은 곳으로 값을 setting한다.
	public String test3(TestVO vo, Model model) {
		System.out.println("TestVO-->"+vo.getUsername()+", "+vo.getAge());
		
		vo.setMsg("vo이용한 request테스트중...");
		
		model.addAttribute("vo", vo);
		
		return "mappingTest/aLinkView2";
	}
	@RequestMapping("/aLink4")
	public ModelAndView test4(TestVO vo) {
		System.out.println("TestVO-----4>"+vo.getUsername()+", "+ vo.getAge());
		
		vo.setMsg("ModelAndView테스트 중...");
		
		//데이터와 뷰 파일명을 한번에 가지는 클래스
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",vo);
		mav.setViewName("mappingTest/aLinkView2");
		
		return mav;
	}
	
	//폼으로 이동하기
	@RequestMapping("/formData")
	public String formTest() {
		return "mappingTest/form";
	}
	
	@RequestMapping(value="/formDataOK", method = RequestMethod.POST)
	public ModelAndView formTestOK(TestVO vo, HttpServletRequest re) {
		System.out.println("formData--->" + vo.getUsername() + ", " + vo.getAge());
		
		vo.setMsg("폼데이터 전송 확인");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("mappingTest/aLinkView2");
		
		return mav;
	}
}
