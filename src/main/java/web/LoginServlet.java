package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginApplication;
import repositories.DummyLoginApplicationRepository;
import repositories.LoginApplicationRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginApplicationRepository repo;
	
	public void init(ServletConfig config) throws ServletException {
		repo = new DummyLoginApplicationRepository();
	} 
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		
  		HttpSession session = request.getSession();
  		LoginApplication application = retreiveDetailsFromRequest(request);
  		//LoginApplicationRepository repo = new DummyLoginApplicationRepository();
  		
  		repo.login(session, application.getUsername(), application.getPassword());
  		  		
  		if (session.getAttribute("logged")!=null && session.getAttribute("logged").equals("true")) {
  			response.sendRedirect("/ProfileServlet");			
  		}
  		else response.sendRedirect("/login.jsp");
	}
  	
  	private LoginApplication retreiveDetailsFromRequest(HttpServletRequest request){
		LoginApplication result = new LoginApplication();
		result.setUsername(request.getParameter("username"));
		result.setPassword(request.getParameter("password"));
		result.setEmail(request.getParameter("email"));
		return result;
	}

	
}
