package exam.action.board;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.dao.MemberDAO;
import exam.dto.MemberVO;
import exam.util.*;

public class LoginAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		MovePage movePage = null;
		SystemLog.printLog("execute()");
		// 1. 요청 파라미터 처리
		String id = (String)request.getParameter("id");
		String pwd = (String)request.getParameter("pwd");			
		
		// 2. DB 처리		
		int result =0;
		try{
			MemberDAO dao = MemberDAO.getInstance();			
			result = dao.login(id, pwd);					
			SystemLog.printLog("login_result : "+result);

		}catch(SQLException e){
			e.printStackTrace();
		}		
		
		// 3. 이동할 페이지 설정
		movePage = new MovePage();
		if(result != 0){	// 성공
			HttpSession session  = request.getSession();
			session.setAttribute("loginId", id);			
			movePage.setPageName("index.jsp");
			movePage.setRedirect(false);
		}		
		else{	// 실패
			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");
			movePage.setPageName("error/error.jsp");				
			movePage.setRedirect(false);			
		}
		
		return movePage;
	}
}
