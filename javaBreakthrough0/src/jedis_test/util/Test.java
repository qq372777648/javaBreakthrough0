
package jedis_test.util;

import redis.clients.jedis.Jedis;


/**
 * @author zdc
 * @since 2015骞�鏈�1鏃� */
public class Test {
   
public static void main(String[] args) {
    JedisUtils jedisUtils=   JedisUtils.getInstance();
       Jedis test=   jedisUtils.getJedis("XXXXXXXXXXXXX", 6379);
       String key ="ddd";
       String value="ddddd2w";
       System.out.println("xxxx");
       test.set(key.getBytes(), value.getBytes());
      byte [] bs=test.get(key.getBytes());
      System.out.println(new String(bs));
}
}
