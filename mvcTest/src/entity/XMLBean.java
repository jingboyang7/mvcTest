package entity;

import java.util.HashMap;
import java.util.Map;

public class XMLBean {
    
	public XMLBean() {
		
	}
	
	private String beanName = "";
	private String beanClass = "";
	private String actionPath = "";
	private String actionClass = "";
	private Map<String,String> actionForward = new HashMap<String,String>();
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getBeanClass() {
		return beanClass;
	}
	public void setBeanClass(String beanClass) {
		this.beanClass = beanClass;
	}
	public String getActionPath() {
		return actionPath;
	}
	public void setActionPath(String actionPath) {
		this.actionPath = actionPath;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	public Map<String, String> getActionForward() {
		return actionForward;
	}
	public void setActionForward(Map<String, String> actionForward) {
		this.actionForward = actionForward;
	}
	
	@Override
	public String toString() {
		return "beanName="+this.beanName+"||beanClass="+this.beanClass+"||actionPath="+this.actionPath+"||actionClass="+this.actionClass;
	}
}
