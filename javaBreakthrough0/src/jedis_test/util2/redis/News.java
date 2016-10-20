package redis;

import java.sql.Date;

public class News {
	private int newsId;
	private String newsTile;
	private String news_address;
	private String news_content;
	private Date date;
	private String author;
	private NewsCategory category;
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTile() {
		return newsTile;
	}
	public void setNewsTile(String newsTile) {
		this.newsTile = newsTile;
	}
	public String getNews_address() {
		return news_address;
	}
	public void setNews_address(String news_address) {
		this.news_address = news_address;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public NewsCategory getCategory() {
		return category;
	}
	public void setCategory(NewsCategory category) {
		this.category = category;
	}
	
	/*public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.newsId);
		sb.append(this.news_content);
	}*/
	
}
