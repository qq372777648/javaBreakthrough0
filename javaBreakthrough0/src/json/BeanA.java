package json;

import com.google.gson.annotations.SerializedName;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��21�� ����9:49:56 
* @Description:  
*/
public class BeanA {
	@SerializedName("trackid")   
	public Integer id;
	public String text;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "BeanA [id=" + id + ", text=" + text + "]";
	}
	public BeanA(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public BeanA(){
		
	}
	

}

