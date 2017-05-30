package com.avivademo.aem.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.avivademo.aem.utils.ArticleDetail;
import com.day.cq.wcm.api.Page;

public class ArticleGrid extends WCMUsePojo{

	ValueMap properties;
	List<ArticleDetail> articles;
	
	private static final Logger LOG = LoggerFactory.getLogger(ArticleGrid.class);
	
	private ResourceResolverFactory resourceResolverFactory;
	
	private ResourceResolver resourceResolver;

	@Override
	public void activate() throws Exception {
		resourceResolver = getResourceResolver();
		resourceResolverFactory = getSlingScriptHelper().getService(ResourceResolverFactory.class);
		properties = getProperties();
		articles = setArticleGrid(properties.get("pagePath", getCurrentPage().getPath()), properties.get("maxLimit", "6"));
	}

	private List<ArticleDetail> setArticleGrid(String pagePath, String resultCount) {
		articles = new ArrayList<>();
		
		try {
			articles.addAll(getChildArticlePages(pagePath, Integer.parseInt(resultCount)));
		} catch(RepositoryException | ParseException ex){
			LOG.error("Error iterating related articles: {} : {}", pagePath , ex);
		}
		return articles;
	}

	private List<ArticleDetail> getChildArticlePages(String pagePath, final int maxLimit) throws RepositoryException, ParseException {
		List<ArticleDetail> articleList = new ArrayList<>();
		Resource pageResource = resourceResolver.getResource(pagePath);
		
		if((null != pageResource) && (pageResource instanceof Resource)) {
			Page currentPage = pageResource.adaptTo(Page.class);
			Iterator<Page> children = currentPage.listChildren();
			int counter = 0;
			while(children.hasNext() && (counter < maxLimit || maxLimit == NumberUtils.INTEGER_MINUS_ONE)){
				Page child = children.next();
				Node node = resourceResolver.resolve(child.getPath() + "/jcr:content").adaptTo(Node.class);
					ArticleDetail article = composeArticleDetail(node, currentPage.getPath());
					articleList.add(article);		
				counter++;
			}
		}
		return articleList;
	}

	private ArticleDetail composeArticleDetail(Node nodeArticle,String currentPath) throws RepositoryException, ParseException {
		ArticleDetail article = new ArticleDetail();
		Node parentNode = resourceResolver.resolve(nodeArticle.getParent().getParent().getPath()+"/jcr:content").adaptTo(Node.class);
		LOG.info("parent name path::"+parentNode.getPath());
		if(!nodeArticle.getPath().equalsIgnoreCase(currentPath+"/jcr:content")){
			if(nodeArticle.hasProperty("pageTitle")){
				article.setArticleTitle(nodeArticle.getProperty("pageTitle").toString());
			}
			if(nodeArticle.hasProperty("jcr:description")){
				article.setArticleDescription(nodeArticle.getProperty("jcr:description").toString());
			}
			article.setPagePath(nodeArticle.getPath().replace("/jcr:content", "")+".html");
				
		}
		return article;
	}
	
	

	
	
	public List<ArticleDetail> getArticles() {
		return articles;
	}
	
	@SuppressWarnings("unchecked")
	public List<ArticleDetail> getRelatedArticles() {
		return articles;
	}
}