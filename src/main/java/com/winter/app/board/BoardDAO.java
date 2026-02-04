package com.winter.app.board;

import java.sql.Connection;
import java.util.List;

public interface BoardDAO {
	
	//list
	public List<BoardDTO> getList(Connection con)throws Exception;
	
	//writer
	public int insert(Connection con, BoardDTO boardDTO)throws Exception;
	
	//update
	public int update(Connection con, BoardDTO boardDTO)throws Exception;
	
	//delete
	public int delete(Connection con, BoardDTO boardDTO)throws Exception;
	
	//조회수 업데이트
	public int updateHit(Connection con, BoardDTO boardDTO)throws Exception;
	
	//detail
	public BoardDTO getDetail(Connection con, BoardDTO boardDTO)throws Exception;

}
