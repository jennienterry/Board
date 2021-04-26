package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/write.jsp";
		request.getRequestDispatcher(jsp).forward(request,response);
		
	}

	// 정보입력하고 글쓰기 눌렀을때 정보가 담김
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// POST 방식 한글 깨짐현상 방지
		String title = request.getParameter("title"); //write.jsp 파일참고
		String ctnt = request.getParameter("ctnt"); // html에서 넘어온 식
		//** client[서버]에서 넘어오는건 무조건 request.getParameter / set 없음 **
		// request.getAttribute 나중에 쓸일 있음 
		
		BoardVO vo = new BoardVO(); //doPost가 만들어질 때마다 새로운 vo 객체가 만들어짐
		                            //= 구조는 같지만 그 전에 만든 애와는 다른 값을 가지는 새로운 그릇
		vo.setTitle(title);
		vo.setCtnt(ctnt);
//		static이었으면 여러값을 담지 못한다 ! private이니까 객체만들고 title,ctnt 정보 담을 수 있는 것	 (수정단계를 줄일 수 있음)
//  	static은 그냥 바로 stack에 바로 올라간다.

//		Database.insertt(title,ctnt); 위 과정없이 이렇게 해도 되긴 함, 깔끔하게 담으려고 한 과정
		Database.list.add(vo); //class명.으로 접근 = static 멤버 필드라는 것
//		34번 풀어쓰면 List<BoardVO> refList = Database.list; refList.add(vo);
		
		response.sendRedirect("/list"); //get방식으로 주소이동하기 !!! 주소값(화면)이동용
//		String jsp = "/WEB-INF/jsp/write.jsp";
//		request.getRequestDispatcher(jsp).forward(request,response); 37과 같은것
	
	}

}

/* 개중요 *

클라이언트 (브라우저)로부터 값이 서버쪽으로 넘어왔다면
값 빼낼 때 : request. getParameter("키값");
           (setParameter 없다.)
----
서블릿에서 jsp로 값 전달할 때
값 넣을 때 : request.setAttribute(키값, value값);
값 빼낼 때 : request.getAttribute(키값);
*/
