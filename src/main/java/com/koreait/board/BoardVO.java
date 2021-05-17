package com.koreait.board;

public class BoardVO {
	private int iboard;
	private String title;
	private String ctnt;

	// 메소드(setter), 생성자
	// 메소드(getter)
	// 값 전달용
	public int getIboard() {
		return iboard;
	}

	public void setIboard(int iboard) {
		this.iboard = iboard;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCtnt() {
		return ctnt;
	}

	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}

}
