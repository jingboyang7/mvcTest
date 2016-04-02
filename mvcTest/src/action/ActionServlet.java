package action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.XMLBean;
import form.ActionForm;
import form.FullForm;


public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("ContextPath="+request.getContextPath());
		
		String path = getServletPath(request);
		Map<String, XMLBean> map = (Map<String, XMLBean>) request.getServletContext().getAttribute("myMVC");
		XMLBean xmlBean = map.get(path);
		ActionForm form = FullForm.full(xmlBean.getBeanClass(), request);
		Action action = null;
		try {
			Class<?> clazz = Class.forName(xmlBean.getActionClass());
			action = (Action) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = action.execute(request, form, xmlBean.getActionForward());
		
		if (url!=null) {
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}
	
    private String getServletPath(HttpServletRequest request) {
        return request.getServletPath().split("\\.")[0];
    }


}
