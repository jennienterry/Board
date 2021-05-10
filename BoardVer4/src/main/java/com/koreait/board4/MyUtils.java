package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {			// /login/user을 String(fileNm)으로 받음
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

