<<<<<<< HEAD
package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class BoardDAO {
	
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board "
				   + "(title, ctnt, iuser) "
				   + "VALUES "
				   + "(?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,param.getTitle());
			ps.setString(2,param.getCtnt());
			ps.setInt(3,param.getIuser());
	
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
		//얘네는 무조건 밖에 위치
		
		String sql = "SELECT A.iboard, A.title, A.iuser, A.regdt, B.unm "
				   + "FROM t_board A "
				   + "LEFT JOIN t_user B "				   
				   + "ON A.iuser = B.iuser "
				   + "ORDER BY iboard DESC";
		//String sql은 try문 안에 있어도 되고 밖에 있어도 된다.
		//sql에서 AS 사용했으면 vo.set할 때도 AS를 한 이름으로 해줘야한다. 아니면 null뜸
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			BoardVO vo = new BoardVO();
			vo.setIboard(rs.getInt("iboard"));
			vo.setTitle(rs.getString("title"));
			vo.setRegdt(rs.getString("regdt"));
			vo.setIuser(rs.getInt("iuser"));
			vo.setUnm(rs.getString("unm"));
			list.add(vo);
			 
		} return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	
	public static BoardVO selBoard (BoardVO param) {
		BoardVO result = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iuser, A.iboard, A.title, A.regdt, A.ctnt, B.unm "
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
			result = new BoardVO();
			result.setIboard(rs.getInt("iboard"));
			result.setTitle(rs.getString("title"));
			result.setRegdt(rs.getString("regdt"));
			result.setUnm(rs.getString("unm"));
			result.setIuser(rs.getInt("iuser"));
			result.setCtnt(rs.getString("ctnt"));
			
		}  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}


		public static int updBoard(BoardVO param) {
			Connection con = null;
			PreparedStatement ps = null;
			
			String sql = "UPDATE t_board "
					   + "SET title =? , ctnt = ? "
					   + "WHERE iboard = ?";
			
			try {
				con = DBUtils.getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1,param.getTitle());  
				ps.setString(2,param.getCtnt());  
				ps.setInt(3,param.getIboard());  
				
				return ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				DBUtils.close(con, ps);
			}
		}
	
		
		public static int delBoard(int param) {
			Connection con = null;
			PreparedStatement ps = null;
			
			String sql = "DELETE "
					   + "FROM t_board "
					   + "WHERE iboard = ?";
			
			try {
				con = DBUtils.getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1,param);
				
				return ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				DBUtils.close(con, ps);
		}
			
	}
}



=======
package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class BoardDAO {
	
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board "
				   + "(title, ctnt, iuser, regdt) "
				   + "VALUES "
				   + "(?, ?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1,param.getTitle());
			ps.setString(2,param.getCtnt());
			ps.setInt(3,param.getIuser());
			ps.setString(4,param.getRegdt());
	
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
				   + "ON A.iuser = B.iuser";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			BoardVO vo = new BoardVO();
			vo.setIboard(rs.getInt("iboard"));
			vo.setTitle(rs.getString("title"));
			vo.setRegdt(rs.getString("regdt"));
			vo.setUnm(rs.getString("unm"));
			list.add(vo);
			 
		} return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
	
	
	public static BoardVO selBoard (BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT A.iuser, A.iboard, A.title, A.regdt, A.ctnt, B.unm "
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
			BoardVO vo = new BoardVO();
			vo.setIboard(rs.getInt("iboard"));
			vo.setTitle(rs.getString("title"));
			vo.setRegdt(rs.getString("regdt"));
			vo.setUnm(rs.getString("unm"));
			vo.setIuser(rs.getInt("iuser"));
			vo.setCtnt(rs.getString("ctnt"));
			
			return vo; 
		} return null; 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}


		public static int updBoard(BoardVO param) {
			Connection con = null;
			PreparedStatement ps = null;
			
			String sql = "UPDATE t_board "
					   + "SET title =? , ctnt = ? "
					   + "WHERE iboard = ?";
			
			try {
				con = DBUtils.getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1,param.getTitle());  
				ps.setString(2,param.getCtnt());  
				ps.setInt(3,param.getIboard());  
				
				return ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				DBUtils.close(con, ps);
			}
		}
	
		
		public static int delBoard(BoardVO param) {
			Connection con = null;
			PreparedStatement ps = null;
			
			String sql = "DELETE "
					   + "FROM t_board "
					   + "WHERE iboard = ?";
			
			try {
				con = DBUtils.getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1,param.getIboard());
				
				return ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				DBUtils.close(con, ps);
		}
			
	}
}



>>>>>>> refs/remotes/origin/main
