package http����.https;

import java.util.HashMap;

/**   
* @author lzw   
* @date 2016��11��11�� ����1:05:47 
* @Description: 
* @version V1.0   
*/
public class Main {
	public static void main(String[] args) {
		System.out.println(HttpUtil.doPostSSL("https://localhost:8444/cpsystem/share/login/login.action",new HashMap<>()));
	}

}
