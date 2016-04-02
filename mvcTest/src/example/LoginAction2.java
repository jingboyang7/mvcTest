package example;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import form.ActionForm;
import action.Action;

public class LoginAction2 implements Action {

	public String execute(HttpServletRequest request, ActionForm form, Map<String,String> actionForward) {
		String forwardName = "";

		LoginForm2 loginForm2 = (LoginForm2)form;
		if (loginForm2.getUserId2() != null && loginForm2.getUserId2().equals(correctId) 
				&& loginForm2.getPassword2() != null && loginForm2.getPassword2().equals(correctPassword)){
			forwardName = fowardNameS;
		}
		else {
			forwardName = fowardNameF;
		}
		
		
		return actionForward.get(forwardName);
	}
	
	private static String correctId = "yId2";
	private static String correctPassword = "yPassword2";
	private static String fowardNameS = "success";
	private static String fowardNameF = "fail";

}
