
import redis.clients.jedis.Jedis; 

/**
 * �򵥸�ֵ
 */
public class Demo_string {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        Jedis jedis = new Jedis("10.20.14.125",6379);  //����redis���� 
          
        //������֤-�����û������redis����ɲ���֤����ʹ���������  
        //jedis.auth("abcdefg");  
          
        //�򵥵�key-value �洢  
        jedis.set("redis", "myredis");  
        System.out.println(jedis.get("redis"));
	}
}
