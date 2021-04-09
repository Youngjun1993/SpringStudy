package com.bitcamp.myapp.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxView")
	public String ajaxView(){
		return "ajax/ajaxView";
	}
	//															한글이 리턴되는 경우 인코딩
	@RequestMapping(value="/ajaxString", method=RequestMethod.GET, produces="application/text; charset=UTF-8")
	@ResponseBody //ajax 컨트롤러인 경우 return이 곧 데이터이다.
	public String ajaxString(String num, String name, String id) {
		return num+", "+name+", "+id;
	}
	/*
	public String ajaxString(HttpServletRequest req) {
		String num = req.getParameter("no");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		
		String msg = "num="+num+", name="+name+", id="+id;
		System.out.println(msg);
		
		return "서버에서 받은 데이터-->"+msg;
	}
	*/
	@RequestMapping("/ajaxObject")
	@ResponseBody
	public TestVO ajaxObject(TestVO vo) {
		vo.setTel("010-1234-1534");
		vo.setAddr("서울시 마포구 백범로");
		return vo;
	}
	
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<TestVO> ajaxList() {
		List<TestVO> list = new ArrayList<TestVO>();
		list.add(new TestVO("1","홍길동","hong","010-1111-2222","서울시 ㅁㅁ구"));
		list.add(new TestVO("2","김길동","kim","010-1111-2222","서울시 ㅇㅇ구"));
		list.add(new TestVO("3","이길동","park","010-1111-2222","서울시 ㅅㅅ구"));
		list.add(new TestVO("4","박길동","choi","010-1111-2222","서울시 ㅂㅂ구"));
		list.add(new TestVO("5","최길동","lee","010-1111-2222","서울시 ㄴㄴ구"));
		return list;
	}
	@RequestMapping("/ajaxMap")
	@ResponseBody
	public HashMap<String, TestVO> ajaxMap() {
		HashMap<String, TestVO> map = new HashMap<String, TestVO>();
		
		map.put("p1", new TestVO("2","이순신","lee","010-1111-2222","서울시 bb구"));
		map.put("p2", new TestVO("3","김순신","kim","010-1111-2222","서울시 aa구"));
		map.put("p3", new TestVO("4","박순신","park","010-1111-2222","서울시 cc구"));
		
		return map;
	}
	
	//자바에서 ajax는 string으로 인식한다.
	@RequestMapping(value="/ajaxJson", method=RequestMethod.GET, produces="application/text; charset=UTF-8")
	@ResponseBody
	public String ajaxJson() {
		int no = 1234;
		String name = "홍길동";
		String tel = "010-1234-1234";
		String addr = "서울시 마포구";
		String email = "abcd@nate.com";
		
		String jsonStr = "{\"no\":\""+no+"\",\"name\":\""+name+"\",\"tel\":\""+tel+"\",\"addr\":\""+addr+"\",\"email\":\""+email+"\"}";
		System.out.println(jsonStr);
		return jsonStr;
	}
	/*
	위 데이터를가지고 아래와같이 문자열로 만들때 쌍따움표를 인식하지 못하게 \로 문자취급을 만들어버린다.
	"{"no":"1234", " name":"홍길동","tel":}"010-1234-1234","addr":"서울시마포구"}"
	
	*/
}
