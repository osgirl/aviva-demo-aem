package com.avivademo.aem.utils;


public class ArticleDetail {
	
	private String pagePath;
	private String articleTitle;
	private String articleSubtitle;
	private String articleHeadline;
	private String articleDescription;
	private String thumbSize;
	
	
	public String getThumbSize() {
		return thumbSize;
	}
	public void setThumbSize(String thumbSize) {
		this.thumbSize = thumbSize;
	}
	
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
	public void setArticleHeadline(String articleHeadline) {
		this.articleHeadline = articleHeadline;
	}
	public String getArticleDescription() {
		return articleDescription;
	}
	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
	
}
