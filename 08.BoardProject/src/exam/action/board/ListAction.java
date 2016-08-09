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

public class ListAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		MovePage movePage = null;
		SystemLog.printLog("execute()");
		// 1. 요청 파라미터 처리
		// 없음
		
		// 2. DB 처리		
		List<BoardVO> list = null;		
		try{
			BoardDAO dao = BoardDAO.getInstance();			
			list = dao.selectAll();		
		}catch(SQLException e){
			e.printStackTrace();
		}		
		
		// 3. 이동할 페이지 설정
		movePage = new MovePage();
		if(list != null){	// 성공
			request.setAttribute("list", list);
			movePage.setPageName("list.jsp");
			movePage.setRedirect(false);
		}		
		else{	// 실패
			request.setAttribute("errorMsg", "리스트 호출에 실패하였습니다.");
			movePage.setPageName("error/error.jsp");				
			movePage.setRedirect(false);			
		}
		
		return movePage;
	}
}
