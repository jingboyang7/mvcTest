package action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import form.ActionForm;

public interface Action {

	String execute(HttpServletRequest request, ActionForm form, Map<String,String> actionForwards);
}
