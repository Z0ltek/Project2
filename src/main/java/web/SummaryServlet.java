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


@WebServlet("/SummaryServlet")
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginApplicationRepository repo;
	
	public void init(ServletConfig config) throws ServletException {
		repo = new DummyLoginApplicationRepository();
	} 
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//HttpSession session = request.getSession();
    	//LoginApplicationRepository repo = new DummyLoginApplicationRepository();
    	response.setContentType("text/html");
    	
    	response.getWriter().print("<h1>Summary page!</h1></br>");
    	
    	response.getWriter().print(repo.summaryPage());
    	
    	response.getWriter().print("</br><a href='/index.jsp'>Home</a>");
    	
	}

}
