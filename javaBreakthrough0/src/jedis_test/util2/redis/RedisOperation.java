package redis;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import redis.clients.jedis.Jedis;


public class RedisOperation {
  private static Charset charset = Charset.forName("utf-8");
  public static String setString(String key,String value){
	  Jedis jedis = RedisFactory.getRedisConnection();
	  String command = jedis.set(key, value);
	  jedis.close();
	  return command;
  }
  
  public static long addList(String key,String[] value){
	  if(key==null || value==null) return -1;
	  Jedis jedis = RedisFactory.getRedisConnection();
	 long result =  jedis.lpush(key, value);
	 jedis.close();
	 return result;
  }
  
  public static String getString(String key){
	  Jedis jedis = RedisFactory.getRedisConnection();
	  String value = jedis.get(key);
	  jedis.close();
	  return value;
  }
  
  public static List<String> getStringList(String key,int start,int end){
	  List<String> list = new LinkedList<String>();
	  Jedis jedis = RedisFactory.getRedisConnection();
	  if(start > end || end > jedis.llen(key)) return list;
	  list = jedis.lrange(key, start, end);
	  jedis.close();
	  return list;
  }
  
  public static byte[] getByteArray(String key){
	  Jedis jedis = RedisFactory.getRedisConnection();
	  byte[] byteArray = jedis.get(key.getBytes(charset));
	  return byteArray;
  }
  
}
