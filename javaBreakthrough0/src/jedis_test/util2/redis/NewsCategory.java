package redis;

import java.io.Serializable;

public class NewsCategory implements Serializable{
	private String newscategory;
	
	public void set(String str){
		this.newscategory = str;
	}
	
	public String get(){
		return this.newscategory;
	}
	
    public String toString(){
	 return this.newscategory; 
    }
}
