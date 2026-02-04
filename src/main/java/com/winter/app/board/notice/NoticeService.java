package com.winter.app.board.notice;

import java.sql.Connection;
import java.util.List;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.DBConnector;

public class NoticeService implements BoardService{
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		this.noticeDAO = new NoticeDAO();
	}
	

	@Override
	public List<BoardDTO> getList() throws Exception {
		Connection con = DBConnector.getConnection();
		List<BoardDTO> ar = noticeDAO.getList(con);
		con.close();
		return ar;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		boardDTO = noticeDAO.getDetail(con, boardDTO);
		con.close();		
		return boardDTO;
	}

}
