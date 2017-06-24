package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.DummyLoginApplicationRepository;
import repositories.LoginApplicationRepository;

@WebServlet("/PremiumEditServlet")
public class PremiumEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginApplicationRepository repo;
	
	public void init(ServletConfig config) throws ServletException {
		repo = new DummyLoginApplicationRepository();
	} 
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession();
    	response.setContentType("text/html");
    	
    	//LoginApplicationRepository repo = new DummyLoginApplicationRepository();
    	
    	String username = request.getParameter("username");
    	
    	if (repo.getPremiumStatus(username).equals("premiumNo")){
    		repo.setPremium(username);
    		response.getWriter().print(""+username+" was granted premium");
    		response.getWriter().print("</br><a href='/index.jsp'>Home</a>");
    	}
    	
    	else if (repo.getPremiumStatus(username).equals("premiumYes")){
    		repo.removePremium(username);
    		response.getWriter().print(""+username+" had premium removed");
    		response.getWriter().print("</br><a href='/index.jsp'>Home</a>");
    	}
    	
    	else {
    		response.getWriter().print("No "+username+" in database");
    		response.getWriter().print("</br><a href='/index.jsp'>Home</a>");
    	}
    	
	}

	

}
