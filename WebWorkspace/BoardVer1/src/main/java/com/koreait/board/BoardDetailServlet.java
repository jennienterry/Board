package com.koreait.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no"); // get에는 키값적기 ! / console에 찍으라고 했으면 여기서 하는게 더 편함
		System.out.println("no : " + no);
		
		request.setAttribute("data", Database.list.get(Integer.parseInt(no))); // ("키값",value=BoardVO객체 주소값)
//		string으로 받기 때문에 int로 형변환 해줘야함
//		BoardVO 정보를 List에 담아놓았기 때문에 Database.list로 접근이 가능한것
//		자주 사용하는 메소드 : get(인덱스값(정수형)), add(넣는값(제네릭, 안하면 다들어감)), remove(인덱스 정수형)), size()
//		BoardVO vo = Database.list.get(no);
		String jsp = "/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
