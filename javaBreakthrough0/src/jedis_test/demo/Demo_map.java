import redis.clients.jedis.Jedis;
import java.util.Map; 
import java.util.HashMap;  
import java.util.List; 

public class Demo_map {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        Jedis jedis = new Jedis("10.20.14.125",6379);  //����redis����  
        
        Map<String,String> user = new HashMap<String,String>();  
        user.put("name", "cd");  
        user.put("password", "123456");  
        
        jedis.hmset("user", user);  //map����redis
        System.out.println(String.format("len:%d", jedis.hlen("user")));  //mapkey���� 
        System.out.println(String.format("keys: %s", jedis.hkeys("user") ));  //map�е����м�ֵ
        System.out.println(String.format("values: %s", jedis.hvals("user") ));  //map�е�����value  
        
        List<String> rsmap = jedis.hmget("user", "name","password");  //ȡ��map�е�name��password�ֶ�ֵ
        System.out.println(rsmap);  
        
        jedis.hdel("user", "password");  //ɾ��map�е�ĳһ����ֵ password  
        System.out.println(jedis.hmget("user", "name", "password"));  
	}

}
