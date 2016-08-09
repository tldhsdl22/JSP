package exam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.dao.MemberDAO;
import exam.dao.MemberVO;

public class RegisterAction implements Action{

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println("id: "+id);
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.parseInt(request.getParameter("age")));
		vo.setAddr(request.getParameter("addr"));
		vo.setTel(request.getParameter("tel"));
		

		MemberDAO dao = MemberDAO.getInstance();
		
		try {
			int result = dao.insertMember(vo);

			 // 데이터 송신		
			PrintWriter out = response.getWriter();
			if(result == 1)
				out.print("success");			
			else
				out.print("fail");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
