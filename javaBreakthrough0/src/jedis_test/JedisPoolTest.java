package jedis_test;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��16�� ����10:27:48 
* @Description:  
*/
public class JedisPoolTest {

	   
	    public static void main(String[] args) {
	        JedisPoolConfig config = new JedisPoolConfig();
	        //������������, Ӧ���Լ���������Ҫ����AliCloudDB for Redisÿ��ʵ������������
	        config.setMaxIdle(200);
	        //���������, Ӧ���Լ���������Ҫ����AliCloudDB for Redisÿ��ʵ������������
	        config.setMaxTotal(300);
	        config.setTestOnBorrow(false);
	        config.setTestOnReturn(false);
	 
	        String host = "127.0.0.1";
	        String password = "root";
	        JedisPool pool = new JedisPool(config, host, 6379, 3000, password);
	        Jedis jedis = null;
	        for(int i = 0; i < 100; i++) {
	            try {
	                final JedisPool poolTemp=pool;
	                final int iTemp=i;
	                new Thread(){
	                	public void run() {
	                		
	                		Jedis j= poolTemp.getResource();
	                		System.out.println("thread"+iTemp+"---"+j.hashCode());
	                		try {
								Thread.sleep(30000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
	                	};
	                }.start();
	                
	            } finally {
	                if (jedis != null) {
	                    jedis.close();
	                }
	            }
	        }
	        pool.close();
	    }
}

