package json.gson;

import com.google.gson.Gson;

import json.BeanA;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��21�� ����11:27:23 
* @Description:  
*/
public class GsonTest {
	public static void main(String[] args) {
		Gson gson=new Gson();
		String json="[{\"trackid\":243,\"text\":\"doubi\",\"text2\":\"doubi222\"},{\"trackid\":2433,\"text\":\"doubi2\"}]";
		BeanA[] a=gson.fromJson(json, BeanA[].class);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println(gson.toJson(a));
	}

}

