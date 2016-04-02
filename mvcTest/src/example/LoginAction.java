package example;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import form.ActionForm;
import action.Action;

public class LoginAction implements Action {

	public String execute(HttpServletRequest request, ActionForm form, Map<String,String> actionForward) {
		String forwardName = "";

		LoginForm loginForm = (LoginForm)form;
		if (loginForm.getUserId() != null && loginForm.getUserId().equals(correctId) 
				&& loginForm.getPassword() != null && loginForm.getPassword().equals(correctPassword)){
			forwardName = fowardNameS;
		}
		else {
			forwardName = fowardNameF;
		}
		
		
		return actionForward.get(forwardName);
	}
	
	private static String correctId = "yId";
	private static String correctPassword = "yPassword";
	private static String fowardNameS = "success";
	private static String fowardNameF = "fail";

}
