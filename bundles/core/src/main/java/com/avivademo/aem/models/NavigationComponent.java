package com.avivademo.aem.models;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.avivademo.aem.beans.LinksBean;

public class NavigationComponent extends WCMUsePojo{
	
	private static final Logger LOG = LoggerFactory.getLogger(NavigationComponent.class);
	
	private List<LinksBean> navigationList = null;

	private final String LINK_LABEL = "linkLabel" ;
	
	private final String LINK_URL = "linkUrl";
	
	@Override
	public void activate() throws Exception {
		
		Node currentNode = getResource().adaptTo(Node.class);
		
		
			setItems(currentNode);
		}
		
	
	
	protected void setItems(Node currentNode) throws RepositoryException{
		
		LinksBean itemBean = new LinksBean();
		Value[] linkLabelArray = null;
		Value[] linkUrlArray = null;
		navigationList = new ArrayList<LinksBean>();
		
		if(currentNode.hasProperty(LINK_LABEL)){
		linkLabelArray = currentNode.getProperty(LINK_LABEL).getValues();
		}
		if(currentNode.hasProperty(LINK_URL)){
			linkUrlArray = currentNode.getProperty(LINK_URL).getValues();
		}
		
		for(int i=0; i<linkLabelArray.length; i++){
			for(int k=0; k<linkUrlArray.length; k++){
				itemBean.setLinkLabel(linkLabelArray[i].getString());
				itemBean.setLinkUrl(linkUrlArray[k].getString());
			}
			navigationList.add(itemBean);
		}
		
	}
	
	@SuppressWarnings("unused")
	private List<LinksBean> getNavigationList(){
		return this.navigationList;
	}
}
