package com.winter.app.memo;

import java.sql.Connection;
import java.util.List;

import com.winter.app.util.DBConnector;

public class MemoService {
	
	private MemoDAO memoDAO;
	
	public MemoService() {
		this.memoDAO = new MemoDAO();
	}
	
	public List<MemoDTO> findAll()throws Exception{
		
//		Connection con = DBConnector.getConnection();
//		
//		con.setAutoCommit(false);
//		
//		List<MemoDTO> ar = memoDAO.findAll(con);
//		
//		con.commit();
		
		return memoDAO.findAll(DBConnector.getConnection());
		
	}

}
