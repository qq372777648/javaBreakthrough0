import redis.clients.jedis.Jedis;


public class Demo_manyString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        Jedis jedis = new Jedis("10.20.14.125",6379);  //����redis����
        
        //mset �����ö��key-valueֵ   ������key1,value1,key2,value2,...,keyn,valuen��  
        //mget �ǻ�ȡ���key����Ӧ��valueֵ  ������key1,key2,key3,...,keyn��  ���ص��Ǹ�list  
        jedis.mset("name1","yangw","name2","demon","name3","elena");  
        System.out.println(jedis.mget("name1","name2","name3"));  
	}

}
