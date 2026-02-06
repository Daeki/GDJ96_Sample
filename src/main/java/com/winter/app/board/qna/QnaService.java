package com.winter.app.board.qna;

import java.sql.Connection;
import java.util.List;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.DBConnector;

public class QnaService implements BoardService {
	
	private QnaDAO qnaDAO;
	
	public QnaService() {
		this.qnaDAO = new QnaDAO();
	}
	
	
	
	public int reply(BoardDTO boardDTO)throws Exception{
		//boardDTO : board_id => 부모의 글번호
		//boardDTO : title, contents, writer => 자식의 정보
		
		Connection con = DBConnector.getConnection();
		
		//1. 부모의 정보를 조회(REF, STEP, DEPTH)
		BoardDTO b = qnaDAO.getDetail(con, boardDTO);
		QnaDTO parent = (QnaDTO)b;
		
		
		
		//2. 조회된 정보를 자식에 저장
		QnaDTO child = (QnaDTO)boardDTO;
		child.setBoard_ref(parent.getBoard_ref());
		child.setBoard_step(parent.getBoard_step()+1);
		child.setBoard_depth(parent.getBoard_depth()+1);
		
		//3. step을 업데이트
		int result = qnaDAO.stepUpdate(con, parent);
		
		//4. 자식을 insert
		
		result = qnaDAO.reply(con, child);
		
		return result;
		
	}
	
	@Override
	public List<BoardDTO> getList() throws Exception {
		Connection con = DBConnector.getConnection();
		List<BoardDTO> ar = qnaDAO.getList(con);
		con.close();
		return ar;
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		int result = qnaDAO.insert(con, boardDTO);
		
		result = qnaDAO.refUpdate(con, boardDTO);
		
		con.close();
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		int result = qnaDAO.update(con, boardDTO);
		
		con.close();
		
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		int result = qnaDAO.delete(con, boardDTO);
		con.close();		
		return result;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		boardDTO = qnaDAO.getDetail(con, boardDTO);
		con.close();		
		return boardDTO;
	}

}
