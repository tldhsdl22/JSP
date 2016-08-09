package exam.action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class WriteAction implements Action {

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WriteAction");
		String path = request.getServletContext().getRealPath("upload");
		System.out.println(path);
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			String title = multi.getParameter("title");
			
			String fileName = multi.getFilesystemName("fileName");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
		
		/*
		MovePage movePage = null;
		SystemLog.printLog("execute()");
		// 1. 요청 파라미터 처리
		String id = (String)request.getSession().getAttribute("loginId");		
		String title = (String)request.getParameter("title");
		String content = (String)request.getParameter("content");			
		
		// 2. DB 처리		
		int result =0;
		try{
			BoardDAO dao = BoardDAO.getInstance();			
			result = dao.insertBoard(id, title, content);					
			SystemLog.printLog("Write Board : "+result);

		}catch(SQLException e){
			e.printStackTrace();
		}		
		
		// 3. 이동할 페이지 설정
		movePage = new MovePage();
		if(result != 0){	// 성공
			movePage.setPageName("index.jsp");
			movePage.setRedirect(true);
		}		
		else{	// 실패
			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");
			movePage.setPageName("error/error.jsp");				
			movePage.setRedirect(false);			
		}
		
		return movePage;
	}*/
}
