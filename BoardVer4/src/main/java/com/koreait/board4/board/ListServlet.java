package com.koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardVO> list = BoardDAO.selBoardList();

		request.setAttribute("list", list);

		HttpSession hs = request.getSession(); // session에 담았기 때문에 EL식 사용가능
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");

		// 로그인 안되어있으면 로그인화면으로 이동
		if (loginUser == null) { //로그아웃 상태면 로그인 페이지로 이동
			response.sendRedirect("/user/login"); // 1차 주소값이 다르기 때문에 /user 넣어줘야 한다.
			return;
		}
		MyUtils.openJSP("board/list", request, response);
		// 로그인 했으면 board/list.jsp 파일 응답
	}
}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		HttpSession hs = request.getSession();
//		// 다른경로에서 로그인없이 접속할 수 없도록 (로그인여부를 검증하기 위해서)
//		Boolean loginSuccess = (Boolean)hs.getAttribute("loginSuccess");
//		System.out.println("loginSuccess: " + loginSuccess);
//		if(loginSuccess == null || loginSuccess == false) {
//			response.sendRedirect("/user/login");
//			return;
//		}
//		MyUtils.openJSP("board/list", request, response);
//	}
