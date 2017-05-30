package com.avivademo.aem.utils;


public class ArticleDetail {
	
	private String pagePath;
	private String articleTitle;
	private String articleSubtitle;
	private String articleHeadline;
	private String articleDescription;
	private String articlePath;
	private String articleImagePath;
	
	
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleSubtitle() {
		return articleSubtitle;
	}
	public void setArticleSubtitle(String articleDesc) {
		this.articleSubtitle = articleDesc;
	}
	public String getPagePath() {
		return pagePath;
	}
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	public String getArticleHeadline() {
		return articleHeadline;
	}
	public String getArticleImagePath() {
		return articleImagePath;
	}
	public void setArticleHeadline(String articleHeadline) {
		this.articleHeadline = articleHeadline;
	}
	public String getArticleDescription() {
		return articleDescription;
	}
	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
	public String getArticlePath() {
		return articlePath;
	}
	public void setArticlePath(String articlePath) {
		this.articlePath = articlePath;
	}
	public void setArticleImagePath(String articleImagePath) {
		this.articleImagePath = articleImagePath;
		
	}

	
	
	
}
