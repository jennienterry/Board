package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board4.DBUtils;

public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_user " + "(uid, upw, unm, gender) " + "VALUES " + "(?, ?, ?, ?)";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getUid()); // JoinServlet에서 set해줬기 때문에 사용가능
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());

			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// return 0; 여기 위치해도 된다.
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;

	}

	// select문 !!
	// 로그인 성공:1, 아이디없음:2, 비밀번호틀림:3, 에러:0
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_user WHERE uid = ?";
		/* SELECT * FROM t_user WHERE uid = 'jimin' AND upw = 'terry';
		   query문에서 이렇게 and를 사용하면 뭐가 틀린지 모름 = 분기를 할 수 없음 */
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid()); // JoinServlet에서 set해줬기 때문에 사용가능
			rs = ps.executeQuery();

			if (rs.next()) {
				// 아이디가 있는 경우 & 비밀번호 체크
				String dbPw = rs.getString("upw");
				if (dbPw.equals(param.getUpw())) {
					return 1;
				} else {
					return 3;
				}
			} else {
				// 아이디가 없는 경우
				return 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}

}
