package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Data Access Object (DB담당)
public class BoardDAO { // db에 실제로 보내는 역할
	// inserBoard를 호출하기 위해서 : static이었으면 BoardDAO 객체생성 먼저 했어야한다.

	// 글등록
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;

		/*
		 * preparedStatement 의 장점 String sql = ~ 에서 (?, ?) 물음표 사용할 수 있음 물음표 안쓰면
		 * '"get.Title( )"' + ~ 가독성 떨어짐
		 */
		String sql = " INSERT INTO t_board " + " (title, ctnt) " // (컬럼)생략가능하지만 생략하면 17번 (?, ?)에서 값을 다 넣어줘야함
				+ " VALUES " + " (?, ?)"; // 변수명.set~ 값 넣을 때 쓰는 것

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, vo.getTitle()); // 정수값 넣을거면 두번째 자리에 int형 넣어야함 = 타입 맞추기
			ps.setString(2, vo.getCtnt()); // ex) ps.setInt(1,111111);
//			(?, ?) 물음표 쓸 때만 하는 과정 -> 변수명.set~ 
			// ps.executeQuery(); //select문 때만 사용
			return ps.executeUpdate(); // insert, update, delete 일 때 사용
										// = int / 몇개의 행에 영향을 미쳤는지에 대한 갯수 (return type int)

		} catch (Exception e) {
			e.printStackTrace(); // 오류정보 담기는 애 // 쿼리문 에러터지면 이게 실행
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

//	=이 있으니까 비void, BoardDAO에 접근했으니까 BoardDAO에 메소드 만들기
//	객체생성 안했으니까 static
	public static List<BoardVO3> selBoardList() {
		List<BoardVO3> list = new ArrayList();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT iboard, title, regdt FROM t_board" + " ORDER BY iboard DESC";
		// "select문 " + " order" 할 때 select문 맨 뒤나, order 맨 앞에 띄어쓰기 해야함
		// 띄어쓰기 안하면 db에서 띄어쓰기가 안되기 때문에 식이 먹히지 않음 !
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery(); // select때만 Query사용

			while (rs.next()) { // true면 실행 = 레코드 있는지(true) 없는지(false) / 최초니까 첫번째꺼 호출0
				BoardVO3 vo = new BoardVO3();
				list.add(vo);

				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");// "컬럼명"
				String regdt = rs.getString("regdt");
				// list니까 ctnt는 필요없음

				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list; // ArrayList주소값을 넣을 것이다.
	}

	public static BoardVO3 selBoard(BoardVO3 bowl) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT title, ctnt, regdt FROM t_board WHERE iboard = ?";
		// 원하는 값의 컬럼명만 적는 것 / join할 때 AS 용이 /where절에 pk가 들어가면 유일하기 때문에 하나의 값만 나온다.
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bowl.getIboard());

			rs = ps.executeQuery();

			if (rs.next()) {

				BoardVO3 vo = new BoardVO3();
				
//				int iboard = rs.getInt("iboard");
				String title = rs.getString("title"); // 컬럼명
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");

				vo.setIboard(bowl.getIboard());
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);

				return vo;

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}

	public static int updateBoard(BoardVO3 param) { // param = 정보가 다 들어가있는 객체상태
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board" + " SET title = ?" + " , ctnt = ?" + " WHERE iboard = ?";
											//set은 한번만 !
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());

			return ps.executeUpdate(); // executeUpdate() : return 안하면 값만 남고 그 값을 사용 안하겠다는 의미가 됨

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}

	public static int delBoard(BoardVO3 param) { // 메소드는 수정하지 않는 것이 좋다.
//		이렇게 int값으로 주면 나중에 메소드와 servlet 둘다 수정해야한다.
//		param.을 이용하면(주소값으로 접근하는 것) 객체인 BoardVO3에 추가만 하면 되기 때문에 수정이 용이하다. (유연)
//		대문자로 시작하면 객체라서 .으로 접근 가능 (ex. BoardVO3 객체니까 / param.으로 접근이 가능하게 되는 것)
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "DELETE FROM t_board WHERE iboard = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);

			ps.setInt(1, param.getIboard());
//			param으로 했기 때문에 클래스에 멤버필드를 추가시키고 여기에는 param.으로 추가만 하면 됨
			System.out.println(ps.toString());
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}

		return 0;
	}
}

//		insert에서
//		BoardVO3 vo = new BoardVO3(); //레코드 수만큼 반복
//		vo.setIboard(1);
//		vo.setTitle("안녕");
//		vo.setRegdt("2021-04-30");
//		list.add(vo);
//		
//		BoardVO3 vo2 = new BoardVO3();
//		vo.setIboard(2);
//		vo2.setTitle("Hello");
//		list.add(vo2);
//		
//		BoardVO3 vo3 = new BoardVO3();
//		vo.setIboard(3);
//		vo3.setTitle("반가워");
//		list.add(vo3);
