
import redis.clients.jedis.Jedis; 
public class Demo_append {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        Jedis jedis = new Jedis("10.20.14.125",6379);  //����redis���� 
        //jedis.auth("abcdefg");  //������֤-�����û������redis����ɲ���֤����ʹ��������� 
          
        jedis.set("redis", "myredis");  //�򵥵�key-value �洢  
        
        //��ԭ��ֵ�û��������,����֮ǰû�и�key�������key  
        //֮ǰ�Ѿ��趨��redis��Ӧ"myredis",�˾�ִ�б��ʹredis��Ӧ"myredisyourredis"  
        jedis.append("redis", "yourredis");     
        jedis.append("content", "rabbit");         
        System.out.println(jedis.get("redis"));
        System.out.println(jedis.get("content"));
	}
}
