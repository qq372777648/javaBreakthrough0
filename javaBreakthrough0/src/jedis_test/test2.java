package jedis_test;

import redis.clients.jedis.Jedis;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��14�� ����5:17:42 
* @Description:  
*/
public class test2 {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.52", 6379);
//		System.out.println("Connection to server sucessfully");
//		// �鿴�����Ƿ�����
//		System.out.println("Server is running: " + jedis.ping());
//		jedis.close();
	}

}

