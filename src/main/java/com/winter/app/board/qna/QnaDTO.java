package com.winter.app.board.qna;

import com.winter.app.board.BoardDTO;

public class QnaDTO extends BoardDTO {
	
	private Long board_ref;
	private Long board_step;
	private Long board_depth;
	
	public Long getBoard_ref() {
		return board_ref;
	}
	public void setBoard_ref(Long board_ref) {
		this.board_ref = board_ref;
	}
	public Long getBoard_step() {
		return board_step;
	}
	public void setBoard_step(Long board_step) {
		this.board_step = board_step;
	}
	public Long getBoard_depth() {
		return board_depth;
	}
	public void setBoard_depth(Long board_depth) {
		this.board_depth = board_depth;
	}
	
	
	

}
