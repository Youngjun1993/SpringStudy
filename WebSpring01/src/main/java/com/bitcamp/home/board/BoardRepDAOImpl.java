package com.bitcamp.home.board;

import java.util.List;

public interface BoardRepDAOImpl {
	//댓글등록
	public int replyInsert(BoardRepVO vo);
	//댓글삭제
	public int replyDelete(int num, String userid);
	//댓글수정
	public int replyUpdate(BoardRepVO vo);
	//글 전체목록
	public List<BoardRepVO> replyAllSelect(int no);
}
