package exam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import exam.dao.MemberDAO;
import exam.dao.MemberVO;

public class ListAction implements Action{

	@Override
	public MovePage execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = MemberDAO.getInstance();
		try {
			List<MemberVO> list = dao.selectAll();
			
			JSONArray arr = new JSONArray();
			for(MemberVO m : list){
				JSONObject object = new JSONObject();
				
				object.put("id", m.getId());
				object.put("name", m.getName());
				object.put("age", m.getAge());
				
				arr.add(object);
			}
			System.out.println(arr);
			PrintWriter out = response.getWriter();
			out.print(arr);			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
}
