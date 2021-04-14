package com.bitcamp.home.board;

import java.util.List;

public interface BoardDAOImpl {
	//리스트
	public List<BoardVO> allList();
	//글쓰기
	public int boardInsert(BoardVO vo);
	//선택하기
	public BoardVO boardSelect(int no);
	//수정하기
	public int boardUpdate(int no, String subject, String content, String userid); //혹은 VO하나를 매개변수로 선언하면된다.
	public int boardDelete(int no, String userid);
}
