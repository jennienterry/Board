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

@WebServlet("/board/detail")//servlet주소
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		int iboard = MyUtils.getParamInt("iboard",request);
//		request.setAttribute("iboard",intIboard); 새로 안만들어주고 받아온거 param.으로 바로 사용해도됨
		BoardVO data = new BoardVO();
		data.setIboard(iboard);
		
		BoardVO vo = BoardDAO.selBoard(data);
		request.setAttribute("vo", vo);
		
		MyUtils.openJSP("board/detail", request, response);//파일주소
		
	}

}
