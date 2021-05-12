package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

@WebServlet("/board/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard",request);
		int iuser = MyUtils.getLoginUserPk(request);
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo.setIuser(iuser);
		BoardDAO.delBoard(vo);
		
		response.sendRedirect("/board/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
