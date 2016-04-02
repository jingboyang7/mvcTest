package example;

import form.ActionForm;

public class LoginForm2 extends ActionForm {
	
	public LoginForm2() {
		
	}
	
	private String userId2 = "";
	private String password2 = "";
	public String getUserId2() {
		return userId2;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword(String password2) {
		this.password2 = password2;
	}
	@Override
	public String toString() {
		return "LoginForm2 [userId2=" + userId2 + ", password2=" + password2 + "]";
	}

}
