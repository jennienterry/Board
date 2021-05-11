package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 화면띄우기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser != null) { //주소값이 null이 아니다 = 로그인이 되어있다
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJSP("user/login", request, response);
	}

	// 로그인처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo); //db와 확인하기 위해서
		
		
		if(result ==1) { //로그인 성공
			HttpSession hs = request.getSession();
			vo.setUpw(null); // 비밀번호는 담을필요 없기 때문에 (위에서 upw담았으니까) null;
			hs.setAttribute("loginUser", vo);
			//vo가 가리키는 UserVO객체는 (iuser, uid, unm값만 담고 있다.)
//			= hs.setAttribute("loginSuccess", true);
			
			//로그인을 유지하기 위해서
			response.sendRedirect("/board/list");
			return;
		}
		String errMsg = null;
		switch(result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해주세요.";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request,response); //바로 위의 메소드를 호출한거
		//response.sendRedirect("login?err=" + result); 이렇게 하면 값전달은 무조건 쿼리스트링으로
		}
	
	}


// doGet의 request와 doPost의 request가 다르다.