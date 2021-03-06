package com.koreait.board3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list3")
public class BoardListServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO3> list = BoardDAO.selBoardList(); //= ( )범위지정 안했다는 의미, 전체 다 들고 오겠다
		//                  = ArrayList객체 주소값
		// return되는 값이 List<BoardVO3>list에 들어가는 것
		// =이 있으니까 비void, BoardDAO에 접근했으니까 BoardDAO에 메소드 만들기
		request.setAttribute("list",list);
		
		
		String jsp = "WEB-INF/view/list3.jsp";
				request.getRequestDispatcher(jsp).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}

