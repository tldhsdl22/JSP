package exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	MovePage execute(HttpServletRequest request, HttpServletResponse response);	
	
}
