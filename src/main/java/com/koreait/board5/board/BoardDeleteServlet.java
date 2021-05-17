package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard",request);
		int loginPk = MyUtils.getLoginUserPk(request);
		int boardIuser = MyUtils.getParamInt("iuser", request);
		if(loginPk != boardIuser) {
			response.sendRedirect("/board/list");
			return;
		}
		int test = BoardDAO.delBoard(iboard);
	
		response.sendRedirect("list");
		
	}


}
