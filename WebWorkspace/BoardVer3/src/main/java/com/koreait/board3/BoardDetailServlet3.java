package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : " + iboard);
		int intIboard = Integer.parseInt(iboard);
		
//		request.setAttribute("",""); 이렇게 해서 보내줘도 하긴 함 ^^;
		
		BoardVO3 param = new BoardVO3();
		param.setIboard(intIboard);
		
		BoardVO3 data = BoardDAO.selBoard(param); //한줄 가져옴 / selBoardList면 여러		
		 
		
		request.setAttribute("data",data);
		
		String jsp = "/WEB-INF/view/detail3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
