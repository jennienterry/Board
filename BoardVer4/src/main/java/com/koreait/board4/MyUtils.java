package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.user.UserVO;

public class MyUtils {			
	
	//로그인user의 정보를 가져옴
	public static UserVO getLoginUser(HttpServletRequest request) {
		if(request == null) {return null;}
		// 프로그래밍 방법론
		// try-catch로 오류를 잡던가 (오류를 예상하고 만드는 것)
		// if는 아예 오류가 없도록 작성, null 반납하고 아래를 실행하지 않음
		// 아래를 실행하면 오류가 나서 멈추니까
		HttpSession hs = request.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}
	
	public static int getLoginUserPk(HttpServletRequest request) {
		UserVO vo = getLoginUser(request);
		return vo.getIuser();
//		return getLoginUser(request).getIuser();
	}
	
	
								// /login/user을 String(fileNm)으로 받음
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
			request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	public static int parseStringInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}
	}
						// 내가 getparam해서 string에서 int로 바꾸는 과정에서 지어주는 키값
	public static int getParamInt(String key, HttpServletRequest request) {
		return parseStringInt(request.getParameter(key));
//		String str = request.getParameter(key);
//		int intStr = Integer.parseInt(str);
//		return intStr;
	}
}

