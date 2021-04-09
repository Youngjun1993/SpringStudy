package com.bitcamp.jdbc.board;

import java.util.List;

public interface BoardReplyDAOImp {
	// 댓글쓰기
	public int replyInsert(BoardReplyVO vo);
	// 댓글수정
	public int replyUpdate(BoardReplyVO vo);
	// 댓글삭제
	public int replyDelete(int num, String userid);
	// 해당글에 해당하는 댓글 전체목록
	public List<BoardReplyVO> replyAllRecord(int no);
}
