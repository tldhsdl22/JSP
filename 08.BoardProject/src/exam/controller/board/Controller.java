package exam.controller.board;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.action.board.Action;
import exam.action.board.MovePage;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns="*.kitri", initParams={
		@WebInitParam(name="url", value="url.properties")})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private Map<String,Action> maps;
       
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		String url=config.getInitParameter("url");	// 초기화된 url변수의 값을 가져옴
		System.out.println(url);
		
		String path = config.getServletContext().getRealPath(url);	// 실제 경로
		System.out.println(path);
		
		Properties prop = new Properties();
		
        try {
			InputStream is = new FileInputStream(path);	// path에서 목록을 참조
			prop.load(is);	//	데이터를 하나씩 리스트 형태로 저장
			

	         Iterator it = prop.keySet().iterator();
	         
	         maps = new HashMap<>();
	         while(it.hasNext())
	         {
	            String key = (String)it.next();
	            String value = prop.getProperty(key);
	            
	            System.out.println(key+", "+value);
	            
	            // 클래스 로드
	            Class<?> clazz = Class.forName(value);
	            
	            // 클래스 객체화
	            Action action = (Action)clazz.newInstance();
	            
	            maps.put(key, action);
	         }

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

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
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

	      String uri = request.getRequestURI();
	      
	      String path = request.getContextPath();
	      
	      String cmd = uri.substring(path.length()+1);
	      
	      /*System.out.println("cmd = " + cmd + maps.get(cmd));*/
	      
	      Action action = maps.get(cmd);
	      MovePage movePage = null;
	      
	      if( action != null)
	      {
	         movePage = action.execute(request, response);
	      }
	      
	      // Redirect
	      if (movePage.isRedirect()) {
	         response.sendRedirect(movePage.getPageName());
	      }
	      // Forward
	      else {
	         RequestDispatcher dispatcher = request.getRequestDispatcher(movePage.getPageName());
	         dispatcher.forward(request, response);
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
