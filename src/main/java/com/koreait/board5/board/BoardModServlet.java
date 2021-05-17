<<<<<<< HEAD
package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board5.MyUtils;
import com.koreait.board5.user.UserVO;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO lu = (UserVO) hs.getAttribute("loginUser");
//		int iuser = lu.getIuser();
		
		if(lu == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo = BoardDAO.selBoard(vo);
		
		request.setAttribute("vo", vo);
		MyUtils.openJSP("board/mod", request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String title = request.getParameter("title");
		 String ctnt = request.getParameter("ctnt");
		 int iboard = MyUtils.getParamInt("iboard", request);
		 
		 int loginPk = MyUtils.getLoginUserPk(request);
		 int boardIuser = MyUtils.getParamInt("iuser", request);
		 if(loginPk != boardIuser) {
			 response.sendRedirect("/board/detail");
			 return;
		 }
		 
		 BoardVO vo = new BoardVO();
		 vo.setTitle(title);
		 vo.setCtnt(ctnt);
		 vo.setIboard(iboard);
		 
		
		 
		 BoardDAO.updBoard(vo);
		 response.sendRedirect("/board/detail?iboard=" + iboard);
	}

}
=======
package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo = BoardDAO.selBoard(vo);
		
		request.setAttribute("vo", vo);
		MyUtils.openJSP("board/mod", request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
>>>>>>> refs/remotes/origin/main
