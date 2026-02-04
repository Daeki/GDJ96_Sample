package com.winter.app.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemoDAO {
	
	
	//List
	public List<MemoDTO> findAll(Connection con)throws Exception{
		//1. DB 연결
		
		//2. SQL문 생성
		String sql ="SELECT * FROM memo";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?에 값을 세팅
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		List<MemoDTO> ar = new ArrayList<MemoDTO>();
		while(rs.next()) {
			MemoDTO memoDTO = new MemoDTO();
			memoDTO.setNum(rs.getLong("num"));
			memoDTO.setTitle(rs.getString("title"));
			memoDTO.setContents(rs.getString("contents"));
			ar.add(memoDTO);
		}
		
		return ar;
		
	}

}
