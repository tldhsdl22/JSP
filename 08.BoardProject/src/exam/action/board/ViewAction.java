package exam.action.board;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exam.dao.BoardDAO;
import exam.dao.MemberDAO;
import exam.dto.BoardVO;
import exam.dto.MemberVO;
import exam.util.*;

public class ViewAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		MovePage movePage = null;
		SystemLog.printLog("execute()");
		// 1. 요청 파라미터 처리
		int selectNum = Integer.parseInt((String)request.getParameter("num"));		
		
		// 2. DB 처리		
		BoardVO vo = null;
		int result = 0;
		try{
			BoardDAO dao = BoardDAO.getInstance();
			result = dao.updateByNum(selectNum);
			vo = dao.selectByNum(selectNum);					
		}catch(SQLException e){
			e.printStackTrace();
		}		
		
		// 3. 이동할 페이지 설정
		movePage = new MovePage();
		if(vo != null && result != 0){	// 성공
			request.setAttribute("detail", vo);
			movePage.setPageName("view.jsp");
			movePage.setRedirect(false);
		}		
		else{	// 실패
			request.setAttribute("errorMsg", "데이터 상세조회 및 조회수 증가에 실패하였습니다.");
			movePage.setPageName("error/error.jsp");				
			movePage.setRedirect(false);			
		}
		
		return movePage;
	}
}
