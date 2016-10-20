package 编码问题;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/** 
* @author lzw 
* @version 创建时间：2016年7月1日 上午11:12:00 
* @Description:  
*/
public class UrlEncode {
	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode("逗逼", "UTF-8"));
			System.out.println(URLDecoder.decode("%E9%80%97%E9%80%BC","UTF-8"));
			
//			中文——>浏览器默认utf-8 -> tomcat默认ISO-8859-1-> new String(name.getBytes("ISO-8859-1"),"UTF-8")得到原始中文
			
			
			//url编码 会把特殊符号也进行编码   如：%：%25    +：%2B   
			System.out.println(URLEncoder.encode("中% #+", "UTF-8"));
			System.out.println(URLEncoder.encode(URLEncoder.encode("中", "UTF-8")));
			System.out.println(URLEncoder.encode(URLEncoder.encode(URLEncoder.encode("中", "UTF-8"))));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

