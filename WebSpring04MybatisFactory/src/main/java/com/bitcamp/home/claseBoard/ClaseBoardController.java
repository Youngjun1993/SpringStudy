package com.bitcamp.home.claseBoard;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClaseBoardController {
	@Autowired
	SqlSession sqlSession;
	
	//글목록
	@RequestMapping("/claseList")
	public String claseList() {
		return "claseboard/claseList";
	}
	//글쓰기 폼
	@RequestMapping("/claseWrite")
	public String claseWrite() {
		return "claseboard/claseWrite";
	}
	//글쓰기 - DB
	@RequestMapping(value="/claseWriteOk", method=RequestMethod.POST)
	public ModelAndView claseWriteOk(ClaseBoardDTO vo, HttpServletRequest req) {
		vo.setIp(req.getRemoteAddr());
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		
		ClaseBoardDAOImpl dao = sqlSession.getMapper(ClaseBoardDAOImpl.class);
		int cnt = dao.claseInsert(vo);
		
		ModelAndView mav = new ModelAndView();
		if(cnt>0) {
			mav.setViewName("redirect:claseList");
		}else {
			mav.setViewName("redirect:claseWrite");
		}
		return mav;
		
	}
}
