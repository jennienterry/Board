package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Remove;

@WebServlet("/del3")
public class BoardDeleteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard"); // detail3에서 쿼리문 iboard로 보냈기 때문에 똑같이 받아야함
		int intIboard = Integer.parseInt(iboard);
//		int intIUser = 10;
		
		BoardVO3 param = new BoardVO3(); //BoardVO3 타입의 param객체 (그릇에 담아서 사용하는 것)
		param.setIboard(intIboard);
//		param.setIuser(intIuser); 값 받아온 경우에 사용가능
		
//		BoardDAO.delBoard(intIboard); // 다이렉트로 값을 보내면 수정이 힘듦 (그릇이 아닌 하나하나 옮겨 사용하는 것)
		BoardDAO.delBoard(param);
		
		response.sendRedirect("/list3");
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
