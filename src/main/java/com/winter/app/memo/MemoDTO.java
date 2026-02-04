package com.winter.app.memo;

public class MemoDTO {
	
	//멤버변수명은 맵핑하는 테이블의 컬럼명과 동일하게, 타입 포함
	//멤버변수의 지정자는 private
	//setter와 getter
	//생성자는 여러개 있어도 상관 없지만 기본생성자는 필수

	//메서드 선언 문법
	//public static void main(String [] args){}
	//제한자 제한자2 리턴타입 메서드명(매개변수들 선언) 
	
	//생성자
	//제한자 클래스명과동일(매개변수들 선언)
	
	
	//클래스는 첫글자 대문자
	//변수, 메서드 첫글자 소문자, 메서드는 뒤에 ()
	
	private Long num;
	private String title;
	private String contents;
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
	
	
	
}
