package com.winter.app.board.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.notice.NoticeDTO;

public class QnaDAO implements BoardDAO{

	@Override
	public List<BoardDTO> getList(Connection con) throws Exception {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		String sql ="SELECT * FROM qna ORDER BY board_ref DESC, board_step ASC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			QnaDTO qnaDTO = new QnaDTO();
			
			qnaDTO.setBoard_id(rs.getLong("board_id"));
			qnaDTO.setBoard_title(rs.getString("board_title"));
			qnaDTO.setBoard_contents(rs.getString("board_contents"));
			qnaDTO.setBoard_writer(rs.getString("board_writer"));
			qnaDTO.setBoard_date(rs.getTimestamp("board_date").toLocalDateTime());
			qnaDTO.setBoard_hit(rs.getLong("board_hit"));
			qnaDTO.setBoard_ref(rs.getLong("board_ref"));
			qnaDTO.setBoard_step(rs.getLong("board_step"));
			qnaDTO.setBoard_depth(rs.getLong("board_depth"));
			
			ar.add(qnaDTO);
		}
		
		return ar;
	}

	@Override
	public int insert(Connection con, BoardDTO boardDTO) throws Exception {
		// 원본글 작성
		// REF => 자기의 글번호, STEP=>0, DEPTH=>0
		String sql="insert into qna values(0 ,?, ?, ?, now(), 0, 0, 0,0)";
		
		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, boardDTO.getBoard_title());
		st.setString(2, boardDTO.getBoard_contents());
		st.setString(3, boardDTO.getBoard_writer());
		
		int result = st.executeUpdate();
		
		ResultSet rs = st.getGeneratedKeys();
		
		rs.next();
		
		boardDTO.setBoard_id(rs.getLong(1));
		
//		sql = "SELECT LAST_INSERT_ID()";
//		
//		st = con.prepareStatement(sql);
//		
//		ResultSet rs = st.executeQuery();
//		rs.next();
//		
//		boardDTO.setBoard_id(rs.getLong(1));
		
		
		
		return result;
	}
	
	
	public int refUpdate(Connection con, BoardDTO boardDTO)throws Exception{
		String sql = "update qna set board_ref=? where board_id=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, boardDTO.getBoard_id());
		st.setLong(2, boardDTO.getBoard_id());
		
		int result = st.executeUpdate();
		
		return result;
	}
	
	public int reply(Connection con, QnaDTO qnaDTO)throws Exception{
	
		String sql="insert into qna values(0 ,?, ?, ?, now(), 0, ?, ?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, qnaDTO.getBoard_title());
		st.setString(2, qnaDTO.getBoard_contents());
		st.setString(3, qnaDTO.getBoard_writer());
		st.setLong(4, qnaDTO.getBoard_ref());
		st.setLong(5, qnaDTO.getBoard_step());
		st.setLong(6, qnaDTO.getBoard_depth());
		
		int result = st.executeUpdate();
		
		
		return result;
	}
	
	public int stepUpdate(Connection con, QnaDTO qnaDTO)throws Exception{
		String sql = "update qna set board_step=board_step+1 where board_ref=? and board_step > ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, qnaDTO.getBoard_ref());
		st.setLong(2, qnaDTO.getBoard_step());
		
		int result= st.executeUpdate();
		
		return result;
		
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
		String sql ="SELECT * FROM qna WHERE board_id=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, boardDTO.getBoard_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			QnaDTO qnaDTO = new QnaDTO();
			
			qnaDTO.setBoard_id(rs.getLong("board_id"));
			qnaDTO.setBoard_title(rs.getString("board_title"));
			qnaDTO.setBoard_contents(rs.getString("board_contents"));
			qnaDTO.setBoard_writer(rs.getString("board_writer"));
			qnaDTO.setBoard_date(rs.getTimestamp("board_date").toLocalDateTime());
			qnaDTO.setBoard_hit(rs.getLong("board_hit"));
			qnaDTO.setBoard_ref(rs.getLong("board_ref"));
			qnaDTO.setBoard_step(rs.getLong("board_step"));
			qnaDTO.setBoard_depth(rs.getLong("board_depth"));
			
			return qnaDTO;
			
		}
		
		return null;
	}

}
