package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list") //웹 페이지에서 요청할 때 주는 주소값
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list.jsp
		request.setAttribute("data",Database.list); //저장은 늘 한 값만 !
		String jsp = "/WEB-INF/jsp/list.jsp"; //실제 파일이 어디 존재하는지에 대한 주소
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
//		request.getRequestDispatcher(jsp).forward(request,response);
		
//		WEB-INF에 있으면 은닉화가 되어서 접근이 불가능하기 때문에 /list에 내용을 담아주는 느낌?
//		원래는 localhost:8090/BoardVer1/WEB-INF/jsp/list.jsp로 접근해야하는데 은닉화때문에 불가능하도록 뜸
//		근데 18,19,20이 존재하면 http://localhost:8090/BoardVer1/list 로도 접근이 가능
		
	}

}
