package com.bitcamp.home.boardReply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardReplyController {
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping("/replyList")
	@ResponseBody
	public List<BoardReplyVO> replyList(int no){
		System.out.println("원글번호="+no);
		BoardReplyDAOImpl dao = sqlSession.getMapper(BoardReplyDAOImpl.class);
		
		return dao.replyAllRecord(no);
	}
	
	@RequestMapping("/replyWrite")
	@ResponseBody
	public String replyInsert(BoardReplyVO vo, HttpServletRequest req) {
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		vo.setIp(req.getRemoteAddr());
		
		BoardReplyDAOImpl dao = sqlSession.getMapper(BoardReplyDAOImpl.class);
		return dao.replyInsert(vo) + "개 추가됨";
	}
	
	@RequestMapping("/replyEdit")
	@ResponseBody
	public String replyEditOk(BoardReplyVO vo, HttpServletRequest req) {
		vo.setUserid((String)req.getSession().getAttribute("logId"));
		
		BoardReplyDAOImpl dao = sqlSession.getMapper(BoardReplyDAOImpl.class);
		return dao.replyUpdate(vo)+"";
	}
	
	@RequestMapping("/replyDel")
	@ResponseBody
	public String replyDel(int num, HttpServletRequest req) {
		BoardReplyDAOImpl dao = sqlSession.getMapper(BoardReplyDAOImpl.class);
		return dao.replyDelete(num, (String)req.getSession().getAttribute("logId")) + "";
	}
}
