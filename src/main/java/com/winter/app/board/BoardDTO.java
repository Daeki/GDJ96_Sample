package com.winter.app.board;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BoardDTO {

	private Long board_id;
	private String board_title;
	private String board_contents;
	private String board_writer;
	private LocalDateTime board_date;
	private Long board_hit;
	
	
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public Long getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(Long board_hit) {
		this.board_hit = board_hit;
	}
	public Long getBoard_id() {
		return board_id;
	}
	public void setBoard_id(Long board_id) {
		this.board_id = board_id;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public LocalDateTime getBoard_date() {
		return board_date;
	}
	public void setBoard_date(LocalDateTime board_date) {
		this.board_date = board_date;
	}
	
	
}
