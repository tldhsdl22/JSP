package exam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.action.Action;
import exam.action.ListAction;
import exam.action.MovePage;
import exam.action.RegisterAction;
import exam.util.SystemLog;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.and")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemLog.printLog("doGet");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String cmd = uri.substring(path.length()+1);		
		SystemLog.printLog("uri: "+cmd);
		
		Action action = null;
		MovePage movePage = null;
		
		// 명령어 구분
		// Action 수행 -> 이동할 페이지 반환받음		
		/*
		 *	회원가입 : register.kitri
		 *	로그인 : login.kitri
		 *	정보삭제 : delete.kitri
		 *	리스트 : list.kitri
		 *	상세내용 : viw.kitri
		 *	
		 *	[Controller에서 수행하는 프로토콜]
		 *	Action을 수행하는 클래스로 이동 -> 수행 후 어디로 이동할지를 반환 -> 해당 페이지로 이동 		
		 */				
		switch(cmd){
		case "register.and" : // 회원가입
			SystemLog.printLog("회원가입");
			action = new RegisterAction();
			movePage = action.execute(request, response);
			break;
		case "list.and":
			SystemLog.printLog("리스트출력");
			/*action = new ListAction();
			movePage = action.execute(request, response);*/
			break;
			/*
		case "delete.kitri":
			action = new DeleteAction();
			movePage = action.execute(request, response);
			break;
		case "list.kitri":
			action = new ListAction();
			movePage = action.execute(request, response);
			break;
		case "view.kitri":
			action = new ViewAction();
			movePage = action.execute(request, response);
			break;*/
		}
/*
		// 페이지 이동
		if(movePage == null){
			SystemLog.printLog("이동할 페이지가 없습니다.");
		}
		else{
			// 리다이렉트
			if(movePage.isRedirect()){
				SystemLog.printLog(movePage.getPageName()+"로 이동(리다이렉트)");
				response.sendRedirect(movePage.getPageName());
			}
			// 포워드
			else{
				SystemLog.printLog(movePage.getPageName()+"로 이동(포워드)");				
				RequestDispatcher dispatcher = request.getRequestDispatcher(movePage.getPageName());
				dispatcher.forward(request, response);
			}
		}*/

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SystemLog.printLog("doGet");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		String cmd = uri.substring(path.length()+1);		
		SystemLog.printLog("uri: "+cmd);
		
		Action action = null;
		MovePage movePage = null;
		
		// 명령어 구분
		// Action 수행 -> 이동할 페이지 반환받음		
		/*
		 *	회원가입 : register.kitri
		 *	로그인 : login.kitri
		 *	정보삭제 : delete.kitri
		 *	리스트 : list.kitri
		 *	상세내용 : viw.kitri
		 *	
		 *	[Controller에서 수행하는 프로토콜]
		 *	Action을 수행하는 클래스로 이동 -> 수행 후 어디로 이동할지를 반환 -> 해당 페이지로 이동 		
		 */				
		switch(cmd){
		case "register.and" : // 회원가입
			System.out.println("회원가입");
			action = new RegisterAction();
			movePage = action.execute(request, response);
			break;			
		case "list.and":
			SystemLog.printLog("리스트출력");
			action = new ListAction();
			movePage = action.execute(request, response);
			break;
			/*
		case "delete.kitri":
			action = new DeleteAction();
			movePage = action.execute(request, response);
			break;
		case "list.kitri":
			action = new ListAction();
			movePage = action.execute(request, response);
			break;
		case "view.kitri":
			action = new ViewAction();
			movePage = action.execute(request, response);
			break;*/
		}
/*
		// 페이지 이동
		if(movePage == null){
			SystemLog.printLog("이동할 페이지가 없습니다.");
		}
		else{
			// 리다이렉트
			if(movePage.isRedirect()){
				SystemLog.printLog(movePage.getPageName()+"로 이동(리다이렉트)");
				response.sendRedirect(movePage.getPageName());
			}
			// 포워드
			else{
				SystemLog.printLog(movePage.getPageName()+"로 이동(포워드)");				
				RequestDispatcher dispatcher = request.getRequestDispatcher(movePage.getPageName());
				dispatcher.forward(request, response);
			}
		}*/

	}

}
