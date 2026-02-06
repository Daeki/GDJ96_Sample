package com.winter.app.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.qna.QnaDAO;
import com.winter.app.board.qna.QnaDTO;
import com.winter.app.util.DBConnector;

public class QnaDAOTest {

	public static void main(String[] args) {
		System.out.println("Qna Test");
		
		QnaDAOTest qnaDAOTest = new QnaDAOTest();
		qnaDAOTest.insertTest();

	}
	
	public void insertTest() {
		QnaDAO qnaDAO = new QnaDAO();
		Connection con = null;
		
		try {
			con= DBConnector.getConnection();
			con.setAutoCommit(false);
			BoardDTO boardDTO = new QnaDTO();
			boardDTO.setBoard_title("qna title2");
			boardDTO.setBoard_contents("qna Contents2");
			boardDTO.setBoard_writer("qna writer2");
			
			int result = qnaDAO.insert(con, boardDTO);
			
			result = qnaDAO.refUpdate(con, boardDTO);
			
			System.out.println("finish");
			
			con.commit();
			
		}catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
	public void listTest() {
		QnaDAO qnaDAO = new QnaDAO();
		try {
			Connection con = DBConnector.getConnection();
			List<BoardDTO> ar = qnaDAO.getList(con);
			if(ar.size()>0) {
				System.out.println("OK");
			}else {
				System.out.println("Fail");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
