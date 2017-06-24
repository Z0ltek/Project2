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


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginApplicationRepository repo;
	
	public void init(ServletConfig config) throws ServletException {
		repo = new DummyLoginApplicationRepository();
	} 
	   
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//LoginApplicationRepository repo= new DummyLoginApplicationRepository();
		
			
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		String premium=(String)session.getAttribute("premium");
		response.setContentType("text/html");
		response.getWriter().print("You are: "+username);
		response.getWriter().print("</br>Your password is: "+password);
		response.getWriter().print("</br>Your premium status is: "+premium);
		
		response.getWriter().print("</br><a href='/index.jsp'>Home</a>");
		
	}
	

	
	}


