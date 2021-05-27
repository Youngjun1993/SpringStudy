package com.bitcamp.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myapp.service.BoardService;
import com.bitcamp.myapp.vo.BoardVO;
import com.bitcamp.myapp.vo.MemberVO;

@Controller
public class BoardController {
	@Inject
	BoardService service;
	
	@RequestMapping("/list")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",service.allList());
		mav.setViewName("board/list");
		return mav;
	}
	@RequestMapping("/view")
	public String boardView(int no, Model model) {
		model.addAttribute("vo",service.boardSelect(no));
		return "board/view";
	}
	
	@RequestMapping("/write")
	public String boardWrite() {
		return "board/write";
	}
	
	@RequestMapping("/writeOk")
	public ModelAndView boardWriteOk(BoardVO vo, HttpServletRequest req) {
		vo.setIp(req.getRemoteAddr());
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		
		ModelAndView mav = new ModelAndView();
		
		if(service.boardInsert(vo)>0) {
			mav.setViewName("redirect:list");
		}else {
			mav.setViewName("redirect:write");
		}
		return mav;
	}
	@RequestMapping("/searchList")
	public ModelAndView boardSearch(BoardVO vo, HttpServletRequest req) {
		vo.setSearchKey(req.getParameter("searchKey"));
		vo.setSearchWord(req.getParameter("searchWord"));
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", service.searchList(vo));
		mav.setViewName("board/list");
		return mav;
	}
	@RequestMapping("/boardEdit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", service.boardEditSelect(no));
		mav.setViewName("board/edit");
		return mav;
	}

	@RequestMapping(value="/boardEditOk", method = RequestMethod.POST)
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		
		ModelAndView mav = new ModelAndView();
		if(service.boardEditOk(vo)>0) { //수정
			mav.addObject("no",vo.getNo());
			mav.setViewName("redirect:view");
		}else {//수정실패
			mav.addObject("no", vo.getNo());
			mav.setViewName("redirect:boardEdit");
		}
		return mav;
	}
	@RequestMapping("/boardDel")
	public ModelAndView boardDel(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		ModelAndView mav = new ModelAndView();
		if(service.boardDelete(vo)>0) {
			mav.setViewName("redirect:list");
		}else {
			mav.addObject("no", vo.getNo());
			mav.setViewName("redirect:view");
		}
		return mav;
	}
	//여러개의 레코드를 한번에 삭제하기
	@RequestMapping("/multiDel")
	public ModelAndView boardMultiDel(BoardVO vo) {
		for(int no : vo.getNoList()) {
			System.out.println("no="+no);
		}
		
		ModelAndView mav = new ModelAndView();
		int result = service.boardMultiDelete(vo.getNoList());
		System.out.println("삭제된 레코드 수 -->" + result);
		mav.setViewName("redirect:list");
		return mav;
	}
}
