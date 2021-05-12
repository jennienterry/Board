package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO t_board " 
				+ "(title, ctnt, iuser) " // 컬럼명
				+ "VALUES "
				+ "(?, ?, ?)"; // 값

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iboard, A.title, A.regdt, B.unm "
				   + "FROM t_board A "
				   + "LEFT JOIN t_user B "
				   + "ON A.iuser = B.iuser "
				   + "ORDER BY A.iboard DESC";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				
				BoardVO vo = new BoardVO();
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	
	public static BoardVO selBoard(BoardVO param){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
													// join걸어서 A나 B나 상관없음
		String sql = "SELECT A.title, A.ctnt, A.regdt, A.iuser, B.unm "
				   + "FROM t_board A "
				   + "LEFT JOIN t_user B "
				   + "ON A.iuser = B.iuser "
				   + "WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				int iuser = rs.getInt("iuser");
				String unm = rs.getString("unm");
				
				vo = new BoardVO();
				vo.setIboard(param.getIboard()); //param.으로 바로 접근가능해서 안담아도 됨
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);
				vo.setIuser(iuser);
				vo.setUnm(unm);
				
			}
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return vo;
		}finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	public static int delBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql="DELETE FROM t_board "
				 + "WHERE iboard = ?"
				 + " AND iuser = ?"; // 다른 사용자가 수정,삭제 못한다.
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,param.getIboard());
			ps.setInt(2, param.getIuser());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static int updBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql= "UPDATE t_board "
				  + "SET title = ?, ctnt = ? "
				  + "WHERE iboard = ?";
	
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
	
	}
	
	
	
}
