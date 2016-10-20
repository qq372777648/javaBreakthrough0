package jedis_test;

import redis.clients.jedis.Jedis;

/** 
* @author lzw 
* @version 创建时间：2016年6月14日 下午5:17:42 
* @Description:  
*/
public class test2 {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.52", 6379);
//		System.out.println("Connection to server sucessfully");
//		// 查看服务是否运行
//		System.out.println("Server is running: " + jedis.ping());
//		jedis.close();
	}

}

