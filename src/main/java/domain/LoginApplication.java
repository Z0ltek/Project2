package domain;

public class LoginApplication {

	String username;
	String email;
	String password;
	String premium = "premiumNo";
	String admin = "adminNo";
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getPremium(){
		return premium;
	}
	
	public void setPremium(String premium){
		this.premium=premium;
	}
	
	public String getAdmin(){
		return admin;
	}
	
	public void setAdmin(String admin){
		this.admin=admin;
	}
}
