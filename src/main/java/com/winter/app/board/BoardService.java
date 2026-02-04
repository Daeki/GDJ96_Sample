package com.winter.app.board;

import java.sql.Connection;
import java.util.List;

public interface BoardService {
	
	//list
	public List<BoardDTO> getList()throws Exception;
	
	//writer
	public int insert(BoardDTO boardDTO)throws Exception;
	
	//update
	public int update(BoardDTO boardDTO)throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO)throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;

}
