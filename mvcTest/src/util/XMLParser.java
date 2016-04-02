package util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.XMLBean;



public class XMLParser {
	
	public static Map<String, XMLBean> configXMLParse(String path) {
		
        Map<String, XMLBean> map = new HashMap<String,XMLBean>();
        
        XMLBean xmlBean = null;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(path));  
	        Node actionForwards = document.getElementsByTagName("action-mappings").item(0);	        
	        NodeList actions = actionForwards.getChildNodes();
	        
	        for (int i = 0; i < actions.getLength(); i++)  
	        {  
	        	
	        	Node actionNode = actions.item(i);
	
	            if(actionNode.getNodeType() == Element.ELEMENT_NODE){
	
	            	xmlBean = new XMLBean();
	                Element actionEle = (Element)actionNode;
	                String actionName = actionEle.getAttribute("name");
	                String actionClass = actionEle.getAttribute("class");
	                String actionPath = actionEle.getAttribute("path");
	                
	                System.out.println("action name: " + actionName);
	                System.out.println("action class: " + actionClass);
	                System.out.println("action path: " + actionPath);
	                xmlBean.setActionClass(actionClass);
	                xmlBean.setActionPath(actionPath);
	                
	                String beanName = "";
	                String beanClass = "";
	                NodeList formBeans = document.getElementsByTagName("formbeans").item(0).getChildNodes();
	                for (int j = 0; j < formBeans.getLength(); j++) {
	                    Node beanNode = formBeans.item(j); 
	
	                    if(beanNode.getNodeType() == Element.ELEMENT_NODE){
	                        Element beanEle = (Element)beanNode;
	                        beanName = beanEle.getAttribute("name");
	                        beanClass = beanEle.getAttribute("class");
	                        if (beanName.equals(actionName)) {
	                            System.out.println("bean name: " + beanName);
	                            System.out.println("bean class: " + beanClass);
	                            xmlBean.setBeanClass(beanClass);
	                            xmlBean.setBeanName(beanName);
	                            break;
	                        }
	                    }
	                }
	                
	                NodeList forwards = actionNode.getChildNodes();
	                Map<String, String> forwardMap = new HashMap<String, String>();
	                
	                for (int k = 0; k < forwards.getLength(); k++) {
	                    Node forwardNode = forwards.item(k);
	                    if(forwardNode.getNodeType() == Element.ELEMENT_NODE){
	                        Element forwardEle = (Element)forwardNode;
	
	                        System.out.println("forward name: " + forwardEle.getAttribute("name"));
	                        System.out.println("forward value: " + forwardEle.getAttribute("value"));
	                        forwardMap.put(forwardEle.getAttribute("name"), forwardEle.getAttribute("value"));
	                    }
	                    xmlBean.setActionForward(forwardMap);
	                }
	                map.put(actionPath, xmlBean);
	            }
	        } 
		} catch (Exception e) {
			e.printStackTrace();
		}   

        for(Map.Entry<String, XMLBean> entry:map.entrySet()){    
            System.out.println(entry.getKey()+"--->"+entry.getValue().getBeanClass());    
        } 
        return map;
	}

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) {
		configXMLParse("WebRoot\\WEB-INF\\myMVC-config.xml");
		
	}
}
