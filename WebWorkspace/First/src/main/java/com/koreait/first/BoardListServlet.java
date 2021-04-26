package com.koreait.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list") // 주소값, 이 주소값으로 요청이 들어오면 get이냐 post에 따라 각 메소드를 호출한다.
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public BoardListServlet() {
        super();
    }
	                                                                  // 여기를 통해 응답
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		response.getWriter()
		.append("Served at: ")
		.append(request.getContextPath())
		.append("rgrg"); // out.print와 같은 효과
		
		PrintWriter out = response.getWriter();
		out.print("dddd");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}

}
