package com.winter.app.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;

public class NoticeDAO implements BoardDAO {

	@Override
	public List<BoardDTO> getList(Connection con) throws Exception {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		String sql ="SELECT * FROM NOTICE ORDER BY board_id DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			
			noticeDTO.setBoard_id(rs.getLong("board_id"));
			noticeDTO.setBoard_title(rs.getString("board_title"));
			noticeDTO.setBoard_contents(rs.getString("board_contents"));
			noticeDTO.setBoard_writer(rs.getString("board_writer"));
			noticeDTO.setBoard_date(rs.getTimestamp("board_date").toLocalDateTime());
			noticeDTO.setBoard_hit(rs.getLong("board_hit"));
			
			ar.add(noticeDTO);
		}
		
		return ar;
	}

	@Override
	public int insert(Connection con, BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection con, BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection con, BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHit(Connection con, BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getDetail(Connection con, BoardDTO boardDTO) throws Exception {
		
		String sql ="SELECT * FROM NOTICE WHERE board_id=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, boardDTO.getBoard_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			boardDTO = new NoticeDTO();
			
			boardDTO.setBoard_id(rs.getLong("board_id"));
			boardDTO.setBoard_title(rs.getString("board_title"));
			boardDTO.setBoard_contents(rs.getString("board_contents"));
			boardDTO.setBoard_writer(rs.getString("board_writer"));
			boardDTO.setBoard_date(rs.getTimestamp("board_date").toLocalDateTime());
			boardDTO.setBoard_hit(rs.getLong("board_hit"));
			
			
		}else {
			boardDTO = null;
		}
		
		return boardDTO;
	}

}










