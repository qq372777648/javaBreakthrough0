package jedis_test;

import redis.clients.jedis.Jedis;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��15�� ����10:49:30 
* @Description:  
*/
public class JedisUtil {
	//pool
	
	public  static Jedis getConnection(){
		
		Jedis jedis=new Jedis("192.168.1.52", 6379);
		jedis.auth("root");
		//jedis.sync();
		return jedis;
	}

}

