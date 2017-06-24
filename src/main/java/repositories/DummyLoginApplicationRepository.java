package repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginApplication;

public class DummyLoginApplicationRepository implements LoginApplicationRepository {

	private static List<LoginApplication> db = new ArrayList<LoginApplication>();
	
	@Override
	public void register(LoginApplication application) throws IOException {
			db.add(application);
    }
	
	@Override
	public void login(HttpSession session, String username, String password) throws IOException{
		
		if (username.equals("Admin")&& password.equals("admin")){
			session.setAttribute("logged", "true");
			session.setAttribute("username", username);
			session.setAttribute("admin", "adminYes");
			session.setAttribute("premium", "premiumYes");
		}
		
		else {
		
  		for (LoginApplication application: db){
  			if(application.getUsername().equals(username) && application.getPassword().equals(password)){
  				session.setAttribute("logged", "true");
  				session.setAttribute("username", username);
  				session.setAttribute("password", password);
  				
  				if (application.getPremium().equals("premiumYes")){
  					session.setAttribute("premium", "premiumYes");
  				}
  				else {
  					 session.setAttribute("premium", "premiumNo");
  				}
  				
  			}
  			else {
  				session.setAttribute("logged", "false");
  				session.setAttribute("premium", "premiumNo");
  				session.setAttribute("admin", "adminNo");
  			}
  		}	
  		}
  		
	}

	@Override
	public LoginApplication getApplicationByUsername(String username) {
		for(LoginApplication application: db){
			if(application.getUsername().equalsIgnoreCase(username))
				return application;
		}
		return null;
	}

	@Override
	public int getSize() {
		return db.size();
	}


	@Override
	public String summaryPage() {
		String summaryText="";
		if (!db.isEmpty()){
			summaryText+= "<table border='1'><tr>"
					+ "<td>Login</td>"
					+ "<td>Password</td>"
					+ "<td>E-mail</td>"
					+ "<td>Premium</td>"
					+ "<td>Admin</td>"
					+ "</tr>";
		  for (LoginApplication la: db) {
			  summaryText+= "<tr>"				
						+ "<td>"+la.getUsername()+"</td>"
						+ "<td>"+la.getPassword()+"</td>"
						+ "<td>"+la.getEmail()+"</td>"
						+ "<td>"+la.getPremium()+"</td>"
						+ "<td>"+la.getAdmin()+"</td>"
						+ "</tr>";
		  }
		  summaryText+= "</table>";
		}
		return summaryText;
	}
	
	@Override
	public void setPremium(String username){
		if (!username.equals("")){
			for(LoginApplication application: db){
				if(application.getUsername().equals(username)){
					application.setPremium("premiumYes");
				}
			}
		}
	}
	
	@Override
	public void removePremium(String username){
		for(LoginApplication application: db){
			if(application.getUsername().equals(username)){
				application.setPremium("premiumNo");
			}
		}
	}
	
	@Override
	public String getPremiumStatus(String username){
		String premiumStatus = "";
		for(LoginApplication application: db){
			if(application.getUsername().equals(username)){
				premiumStatus= application.getPremium();
			}
		}
		return premiumStatus;
	}

	
}
