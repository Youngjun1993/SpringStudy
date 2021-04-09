package com.bitcamp.home.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardRepController {
	//댓글쓰기
	@RequestMapping("/replyWriteOk")
	@ResponseBody
	public String replyWriteOk(BoardRepVO vo, HttpServletRequest req) {
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		vo.setIp(req.getRemoteAddr());
		
		BoardRepDAO dao = new BoardRepDAO();
		return dao.replyInsert(vo)+"개 추가";
	}
	@RequestMapping("/replyList")
	@ResponseBody
	public List<BoardRepVO> replyList(int no){
		BoardRepDAO dao = new BoardRepDAO();
		return dao.replyAllSelect(no);
	}
}
