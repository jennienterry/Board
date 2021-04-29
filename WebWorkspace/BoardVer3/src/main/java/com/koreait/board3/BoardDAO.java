package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;

// Data Access Object (DB담당)
public class BoardDAO { //db에 실제로 보내는 역할
	
	//글등록           
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board "
					+ " (title, ctnt) "
					+ " VALUES "
					+ " (?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle()); //정수값 넣을거면 두번째 자리에 int형 넣어야함 = 타입 맞추기
			
			ps.executeQuery()
			
		} catch(Exception e) {
			e.printStackTrace(); // 오류정보 담기는 애
		} finally {
			DBUtils.close(con,ps);
		}
	
	
		return 0;
	}

}
