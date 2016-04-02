package example;

import form.ActionForm;

public class LoginForm extends ActionForm {
	
	public LoginForm() {
		
	}
	
	private String userId = "";
	private String password = "";
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [userId=" + userId + ", password=" + password + "]";
	}

}
