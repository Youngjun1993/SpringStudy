package com.bitcamp.home.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping("/boardList")
	public ModelAndView allList() {
		BoardDAOImpl dao = sqlSession.getMapper(BoardDAOImpl.class);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.allList());
		mav.setViewName("board/boardList");
		return mav;
	}
	
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/boardWriteOk", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView boardWriteOk(BoardVO vo, HttpSession session, HttpServletRequest req) {
		vo.setIp(req.getRemoteAddr());
		vo.setUserid((String)session.getAttribute("logId"));
		
		BoardDAOImpl dao = sqlSession.getMapper(BoardDAOImpl.class);
		int cnt = dao.boardInsert(vo);
		
		ModelAndView mav = new ModelAndView();
		if(cnt>0) {//등록
			mav.setViewName("redirect:boardList");
		}else {
			mav.setViewName("redirect:boardWrite");
		}
		return mav;
	}
	
	@RequestMapping("/boardView")
	public String boardView(int no, Model model) {
		BoardDAOImpl dao = sqlSession.getMapper(BoardDAOImpl.class);
		BoardVO vo = dao.boardSelect(no);
		model.addAttribute("vo", vo); //view페이지에서 사용한다.
		return "board/boardView";
	}
	
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(int no) {
		BoardDAOImpl dao = sqlSession.getMapper(BoardDAOImpl.class);
		BoardVO vo = dao.boardSelect(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", dao.boardSelect(no));
		mav.setViewName("board/boardEdit");
		return mav;
	}
	
	@RequestMapping(value="/boardEditOk", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session) {
		BoardDAOImpl dao = sqlSession.getMapper(BoardDAOImpl.class);
		int cnt = dao.boardUpdate(vo.getNo(), vo.getSubject(), vo.getContent(), (String)session.getAttribute("logId"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", vo.getNo());
		if(cnt>0) {//수정--글내용보기
			mav.setViewName("redirect:boardView");
		}else {//수정--글수정 폼으로
			mav.setViewName("redirect:boardEdit");
		}
		return mav;
	}
	
	@RequestMapping("/boardDel")
	public ModelAndView boradDel(int no, HttpSession session) {
		BoardDAOImpl dao = sqlSession.getMapper(BoardDAOImpl.class);
		
		ModelAndView mav = new ModelAndView();
		if(dao.boardDelete(no, (String)session.getAttribute("logId"))>0) {//삭제
			mav.setViewName("redirect:boardList");
		}else {
			mav.addObject("no", no);
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
}
