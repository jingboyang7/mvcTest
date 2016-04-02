package action;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.XMLParser;

public class ActionListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		String xmlpath = context.getInitParameter("mvc-config");
		String tomcatpath =context.getRealPath("\\");
		System.out.println("path="+tomcatpath+xmlpath);
		
		context.setAttribute("myMVC", XMLParser.configXMLParse(tomcatpath+xmlpath));
	}

}
