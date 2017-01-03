package http请求.https;

import java.util.HashMap;

/**   
* @author lzw   
* @date 2016年11月11日 下午1:05:47 
* @Description: 
* @version V1.0   
*/
public class Main {
	public static void main(String[] args) {
		System.out.println(HttpUtil.doPostSSL("https://localhost:8444/cpsystem/share/login/login.action",new HashMap<>()));
	}

}
