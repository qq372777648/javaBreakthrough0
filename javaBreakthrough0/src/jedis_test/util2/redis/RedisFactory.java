package redis;

import jedis_test.util2.global.RedisInfo;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisFactory {
	private static JedisPool jedisPool = null;
	private static final int MAX_WAIT = 1000;
	private static final int MAX_ACTIVE = 20;
	private static final int MAX_IDLE = 10;
	private static final boolean TEST_ON_BORROW = true;
	{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(MAX_IDLE);
		config.setMaxWaitMillis(MAX_WAIT);
		config.setMaxTotal(MAX_ACTIVE);
		config.setTestOnBorrow(TEST_ON_BORROW);
		jedisPool = new JedisPool(config,RedisInfo.HOSTIP,RedisInfo.PORT);
	}
	public static Jedis getRedisConnection(){
		return jedisPool.getResource();
	}
	
	public static void close(){
		if(jedisPool!=null){
			jedisPool.close();
		}
	}
}
