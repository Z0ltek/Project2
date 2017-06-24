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

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginApplicationRepository repo;
	
	public void init(ServletConfig config) throws ServletException {
		repo = new DummyLoginApplicationRepository();
	}
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("logged")==null || session.getAttribute("logged").equals(false)) {
			LoginApplication application = retreiveDetailsFromRequest(request);
			//LoginApplicationRepository repo = new DummyLoginApplicationRepository();
			response.setContentType("text/html");
			if (!application.getUsername().equals("") && !application.getPassword().equals("") && !application.getEmail().equals("") && request.getParameter("password").equals(request.getParameter("confpassword"))){
				//session.setAttribute("registration", application);
				session.setAttribute("premium", "premiumNo");
				session.setAttribute("admin", "adminNo");
				repo.register(application);
				response.getWriter().print("Thank you for registering</br>");
				response.getWriter().print("<a href='/login.jsp'>Please log in");
			}
			else {
				response.sendRedirect("/");
			}
		}
		else {
			response.getWriter().print("You are already logged in. No need of registration!");
		}
	}

	private LoginApplication retreiveDetailsFromRequest(HttpServletRequest request){
		LoginApplication result = new LoginApplication();
		result.setUsername(request.getParameter("username"));
		result.setPassword(request.getParameter("password"));
		result.setEmail(request.getParameter("email"));
		return result;
	}

}
