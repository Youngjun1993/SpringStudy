package com.bitcamp.home.board;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.home.DBCPConnection;

public class BoardDAO extends DBCPConnection implements BoardDAOImpl {

	@Override
	public int boardInsert(BoardVO vo) {
		int result=0;
		try {
			getConn();
			sql = "insert into board(no, subject, content, userid, ip) "
					+ "values(boardsq.nextval, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getUserid());
			pstmt.setString(4, vo.getIp());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("글쓰기 에러...");
			e.printStackTrace();
		}finally {
			setClose();
		}
		
		return result;
	}

	@Override
	public List<BoardVO> boardAllRecord() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			getConn();
			sql = "select no, subject, userid, hit, writedate from board order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setUserid(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setWritedate(rs.getString(5));
				list.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("레코드전제선택 DAO 에러 !!!");
			e.printStackTrace();
		}finally {
			setClose();
		}
		
		return list;
	}

	@Override
	public void boardSelect(BoardVO vo) {
		try {
			getConn();
			sql = "select no, subject, content, userid, hit, writedate, ip from board where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setUserid(rs.getString(4));
				vo.setHit(rs.getInt(5));
				vo.setWritedate(rs.getString(6));
			}
		}catch(Exception e) {
			System.out.println("레코드선택DAO 에러 !!!");
			e.printStackTrace();
		}finally {
			setClose();
		}
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		int result=0;
		try {
			getConn();
			sql="update board set subject=?, content=? where no=? and userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSubject());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNo());
			pstmt.setString(4, vo.getUserid());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("게시판업데이트DAO 에러!!!");
			e.printStackTrace();
		}finally {
			setClose();
		}
		return result;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		int result=0;
		try {
			getConn();
			sql="delete from board where no=? and userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getUserid());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("게시판삭제DAO 에러!!!");
			e.printStackTrace();
		}finally {
			setClose();
		}
		return result;
	}

	@Override
	public void hitCount(int no) {
		try {
			getConn();
			
			sql="update board set hit=hit+1 where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("조회수증가에러");
			e.printStackTrace();
		}finally {
			setClose();
		}
	}

}
