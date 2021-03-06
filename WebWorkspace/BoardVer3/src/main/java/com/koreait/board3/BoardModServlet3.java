package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod3")
public class BoardModServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	// 수정 창 띄우기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : " + iboard);
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 b = new BoardVO3();
		b.setIboard(intIboard);
		BoardVO3 data = BoardDAO.selBoard(b);
		request.setAttribute("data",data);
		
		String jsp = "/WEB-INF/view/mod3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
// 		detailservlet과 비슷하다
	}

	
	// 실제 수정하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		글 등록 이후이기 때문에 몇번 글인가에 대한 정보가 추가로 더 필요
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title"); //html에서 오는 것은 parameter
		String ctnt = request.getParameter("ctnt");
		
		System.out.printf("iboard : "+ iboard );
		System.out.printf("title : "+ title );
		System.out.printf("ctnt : "+ ctnt );
		
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 vo = new BoardVO3(); 
		vo.setIboard(intIboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDAO.updateBoard(vo);
		
		response.sendRedirect("/detail3?iboard=" + iboard); //list3.jsp파일 보면 내가 detail3로 갈 때 사용했던 쿼리를 볼 수 있다.
												// 이미 String인 것으로 보내는 것
//		writeservlet과 비슷하다
	}

}
