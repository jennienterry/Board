package com.koreait.board4.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession(); //session에 담았기 때문에 EL식 사용가능
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		
		//로그인 안되어있으면 로그인화면으로 이동
		if(loginUser == null) {
		response.sendRedirect("/user/login"); //1차 주소값이 다르기 때문에 /user 넣어줘야 한다.
		return;
		}
		MyUtils.openJSP("board/write", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		HttpSession hs = request.getSession();
		UserVO userVO = (UserVO)hs.getAttribute("loginUser");
//		int iuser = userVO.getIuser(); //UserVO보면 타입이 int임
//		int iuser = loginUser.getIuser(); // 다른사용자가 내 글을 수정,삭제 못하도록 하는 것
		
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setCtnt(ctnt);
		param.setIuser(userVO.getIuser()); // (iuser)
		
		int intVO = BoardDAO.insBoard(param);
		response.sendRedirect("list");
	}

}
