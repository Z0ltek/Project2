package repositories;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginApplication;

public interface LoginApplicationRepository {

	LoginApplication getApplicationByUsername (String username);
	
	int getSize();
	
	
	void login(HttpSession session, String username, String password) throws IOException;

	void register(LoginApplication application) throws IOException;
	
	public String summaryPage();

	void setPremium(String username);

	void removePremium(String username);

	String getPremiumStatus(String username);
	
}
