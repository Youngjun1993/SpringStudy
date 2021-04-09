package com.bitcamp.home.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@RequestMapping("/boardList")
	public ModelAndView boardList() {
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.boardAllRecord();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("board/boardList");
		
		return mav;
	}
	@RequestMapping("/boardWrite")
	public String boardWrite(HttpServletRequest req) {
		HttpSession ses =  req.getSession();
		//로그인 안된경우 로그인, 로그인 된경우 글쓰기
		String logStatus = (String)ses.getAttribute("logStatus");
		if(logStatus != null && logStatus.equals("Y")) {
			return "board/boardWrite";
		}else {
			return "member/loginform";
		}
	}
	@RequestMapping(value="/boardWriteOk", method=RequestMethod.POST)
	public ModelAndView boardWriteOk(HttpServletRequest req, BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		BoardDAO dao = new BoardDAO();
		
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		vo.setIp(req.getRemoteAddr());
		
		int result = dao.boardInsert(vo);
		if(result>0) {
			mav.setViewName("redirect:boardList");
		}else {
			mav.setViewName("board/boardWriteOk");
		}
		return mav;
	}
	@RequestMapping("/boardView")
	public ModelAndView boardView(BoardVO vo) {
		BoardDAO dao = new BoardDAO();
		dao.boardSelect(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",vo);
		mav.setViewName("board/boardView");
		
		return mav;
	}
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(BoardVO vo) {
		BoardDAO dao = new BoardDAO();
		dao.boardSelect(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",vo);
		mav.setViewName("board/boardEdit");
		
		return mav;
	}
	@RequestMapping(value="/boardEditOk", method=RequestMethod.POST)
	public ModelAndView boardEditOk(BoardVO vo, HttpServletRequest req) {
		HttpSession ses = req.getSession();
		vo.setUserid((String)ses.getAttribute("logId"));
		
		BoardDAO dao = new BoardDAO();
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", vo.getNo());
		
		int result = dao.boardUpdate(vo);
		
		if(result>0) {//글수정시 
			mav.setViewName("redirect:boardView");
		}else {
			mav.setViewName("redirect:boardEdit");
		}
		return mav;
	}
	@RequestMapping("/boardDel")
	public ModelAndView boardDel(BoardVO vo, HttpServletRequest req) {
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		
		BoardDAO dao = new BoardDAO();
		int result = dao.boardDelete(vo);
		
		ModelAndView mav = new ModelAndView();
		if(result>0) {
			mav.setViewName("redirect:boardList");
		}else {
			mav.addObject("no", vo.getNo());
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
}
