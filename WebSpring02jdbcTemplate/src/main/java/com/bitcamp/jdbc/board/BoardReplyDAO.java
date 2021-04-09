package com.bitcamp.jdbc.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.bitcamp.jdbc.Constants;

public class BoardReplyDAO implements BoardReplyDAOImp {
	public JdbcTemplate template;
	public BoardReplyDAO() {
		template = Constants.jdbcTemplate;
	}
	@Override
	public int replyInsert(final BoardReplyVO vo) {
		String sql = "insert into boardReply(num, no, content, userid, ip) values(boardsq.nextval, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, vo.getNo()); //원글번호
				ps.setString(2, vo.getContent());
				ps.setString(3, vo.getUserid());
				ps.setString(4, vo.getIp());
				
			}
		});
	}
	@Override
	public int replyUpdate(BoardReplyVO vo) {
		String sql = "update boardReply set content=? where num=? and userid=?";
		return template.update(sql, vo.getContent(), vo.getNum(), vo.getUserid());
	}
	@Override
	public int replyDelete(int num, String userid) {
		String sql = "delete from boardReply where num=? and userid=?";
		return template.update(sql, num, userid);
	}
	@Override
	public List<BoardReplyVO> replyAllRecord(int no) {
		String sql = "select num, content, userid, replydate from boardReply where no=? order by num";
		
		return template.query(sql, new BeanPropertyRowMapper<BoardReplyVO>(BoardReplyVO.class), no);
	}

}
