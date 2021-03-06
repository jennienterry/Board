package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.MyUtils;

@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}
										// join.jsp에서 온거
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uid = request.getParameter("uid");
			String upw = request.getParameter("upw");
			String unm = request.getParameter("unm");
//			String gender = request.getParameter("gender");
//			int intGender = Integer.parseInt(gender);
			int intGender = MyUtils.getParamInt("gender",request);
			
			//비밀번호 암호화
			String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());
			System.out.println("hashedUpw : " + hashedUpw);
			
			UserVO vo = new UserVO();
			vo.setUid(uid);
			vo.setUpw(hashedUpw); //암호화된 비밀번호
			vo.setUnm(unm);
			vo.setGender(intGender);
			
			UserDAO.joinUser(vo); //실행만 하기 때문에 담을필요가 없음 (전달해줄게 없으니까 executeUpdate한거)
			response.sendRedirect("login"); // = /user/login 앞에 /적으면 1차 주소값이 날라간다.
	}

}
