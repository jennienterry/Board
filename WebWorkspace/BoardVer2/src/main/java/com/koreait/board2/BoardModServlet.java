 package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String str = request.getParameter("no");	
		 int intNo = Integer.parseInt(str);
		 
		 BoardVO vo = Database.db.get(intNo);
		 
		 request.setAttribute("vo", vo);
		 
		String jsp = "WEB-INF/jsp/mod.jsp";
			request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String index = request.getParameter("index");
		int idx = Integer.parseInt(index);
		
		Database.db.get(idx).setCtnt(ctnt);
		Database.db.get(idx).setTitle(title);
		
		response.sendRedirect("/detail?no=" + idx);
		
		
	}

}
