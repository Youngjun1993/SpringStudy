package com.bitcamp.home.claseBoard;

import java.util.List;

public interface ClaseBoardDAOImpl {
	public int claseInsert(ClaseBoardDTO dto);
	public List<ClaseBoardDTO> claseAllRecord();
	public ClaseBoardDTO claseSelect(int no);
	public int hitCount(int no);
	public ClaseBoardDTO oriInfor(int no);//원글의 ref, step, lvl를 선택
	public int lvlCount(ClaseBoardDTO dto);//lvl증가
	public int claseDataInsert(ClaseBoardDTO dto);
	public int getTotalRecord();//총레코드수 구하기
	public int claseUpdate(ClaseBoardDTO dto);//답변형 글수정
	public ClaseBoardDTO getStep(int no);//step, userid를 가져온다.
	public int claseDelete(int no);//원글삭제
	public int claseDeleteUpdate(int no, String userid);//답글삭제
	public ClaseBoardDTO getNumTitle(int no);//이전글, 다음글
}
