package com.bitcamp.jdbc.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.bitcamp.jdbc.Constants;

public class BoardDAO implements BoardDAOImp{
	public JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public BoardDAO() {
		template = Constants.jdbcTemplate;
	}
	
	@Override
	public List<BoardVO> boardAllRecord() {
		String sql = "select no, subject, userid, hit, to_char(writedate, 'MM-DD HH:MI') writedate from board order by no desc";
		//				select를 실행하여 vo에 데이터를 셋팅하고 List에 vo객체를 추가하여 리턴해준다.
		return template.query(sql, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}

	@Override
	public BoardVO boardOneRecord(int no) {
		String sql = "select no, subject, content, userid, hit, writedate from board where no=?";
		
		return template.queryForObject(sql, new Object[] {no}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}

	@Override
	//						익명의 내부클래스에서 값을 부를떄 final로 불러야한다.
	public int boardInsertRecord(final BoardVO vo) {
		try {
			String sql = "insert into board(no, subject, userid, content, ip) "
					+ "values(boardsq.nextval, ?, ?, ?, ?)";
			
			//template.update(sql, vo.getSubject(), vo.getUserid(), vo.getContent(), vo.getIp())로도 가능하며 int가 리턴된다.
			return template.update(sql, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, vo.getSubject());
					ps.setString(2, vo.getUserid());
					ps.setString(3, vo.getContent());
					ps.setString(4, vo.getIp());
				}
				
			});
		}catch(Exception e) {
			return 0;
		}
	}

	@Override
	public int boardUpdateRecord(BoardVO vo) {
		String sql = "update board set subject=?, content=? where no=? and userid=?";
		
		return template.update(sql, vo.getSubject(), vo.getContent(), vo.getNo(), vo.getUserid());
	}

	@Override
	public int boardDeleteRecord(final int no,final String userid) {
		String sql = "delete from board where no=? and userid=?";
		return template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, no);
				ps.setString(2, userid);
			}
		});
	}

	@Override
	public void hitCout(int no) {
		String sql = "update board set hit=hit+1 where no=?";
		template.update(sql, no);
	}

}
