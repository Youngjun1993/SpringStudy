package com.bitcamp.jdbc.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.bitcamp.jdbc.Constants;

public class DataDAO implements DataDAOImpl {
	public JdbcTemplate template;
	public DataDAO() {
		template = Constants.jdbcTemplate;
	}
	@Override
	public List<DataVO> allList() {
		String sql = "select no, title, userid, filename1, filename2, hit, writedate from data order by no desc";
		return template.query(sql, new BeanPropertyRowMapper<DataVO>(DataVO.class)); 
	}
	@Override
	public int dataInsert1(final DataVO vo) {
		String sql="insert into data(no, title, content, userid, ip, filename1, filename2) "
				+ "values(boardsq.nextval, ?, ?, ?, ?, ?, ?)";
		return template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getContent());
				ps.setString(3, vo.getUserid());
				ps.setString(4, vo.getIp());
				ps.setString(5, vo.getFilename1());
				ps.setString(6, vo.getFilename2());
				
			}
		});
	}
	@Override
	public DataVO dataSelect(int no) {
		String sql = "select no, title, content, userid, hit, downCount, writedate, filename1, filename2 "
				+ "from data where no=?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<DataVO>(DataVO.class), no);
	}
	@Override
	public DataVO getSelectFilename(int no) {
		String sql = "select filename1, filename2 from data where no=?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<DataVO>(DataVO.class), no);
	}
	@Override
	public int dataUpdate(DataVO vo) {
		String sql = "update data set title=?, content=?, filename1=?, filename2=? where no=? and userid=?";
		return template.update(sql, vo.getTitle(), vo.getContent(), vo.getFilename1(), vo.getFilename2(), vo.getNo(), vo.getUserid());
	}
	@Override
	public int dataDelete(int no, String userid) {
		String sql = "delete from data where no=? and userid=?";
		return template.update(sql, no, userid);
	}
	
}
