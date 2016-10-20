package jedis_test;

import java.util.Arrays;
import java.util.List;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��6��16�� ����2:53:21
 * @Description:
 */
public class ShardedJedisTest {
	private ShardedJedis shardedJedis;// ��Ƭ��ͻ�������
	private ShardedJedisPool shardedJedisPool;// ��Ƭ���ӳ�

	public void init() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(2);
		poolConfig.setMaxIdle(1);
		poolConfig.setMaxWaitMillis(2000);
		poolConfig.setTestOnBorrow(false);
		poolConfig.setTestOnReturn(false);

		// ����Redis��Ϣ
		String host = "127.0.0.1";
		JedisShardInfo shardInfo1 = new JedisShardInfo(host, 6379, 500);
		//shardInfo1.setPassword("");
		JedisShardInfo shardInfo2 = new JedisShardInfo(host, 6380, 500);
		//shardInfo2.setPassword("");
		JedisShardInfo shardInfo3 = new JedisShardInfo(host, 6381, 500);
		//shardInfo3.setPassword("");

		// ��ʼ��ShardedJedisPool
		List<JedisShardInfo> infoList = Arrays.asList(shardInfo1,shardInfo2,shardInfo3);
		shardedJedisPool = new ShardedJedisPool(poolConfig, infoList);
	}

	public ShardedJedisTest(){
		init();
	}
	
	public void op() {
		// ���в�ѯ����������
		try {
			shardedJedis = shardedJedisPool.getResource();
			shardedJedis.set("test108", "test");
			shardedJedis.set("test", "test");
			shardedJedis.set("test1", "test1");
			String test = shardedJedis.get("test");
			System.out.println(test);
			
			
			shardedJedis.set("cnblog3", "cnblog");
	        shardedJedis.set("redis3", "redis");
	        shardedJedis.set("test3", "test");
	        shardedJedis.set("1234563", "1234567");
	        Client client1 = shardedJedis.getShard("cnblog3").getClient();
	        Client client2 = shardedJedis.getShard("redis3").getClient();
	        Client client3 = shardedJedis.getShard("test3").getClient();
	        Client client4 = shardedJedis.getShard("1234563").getClient();
	        
	        ////��ӡkey���ĸ�server��
	        System.out.println("cnblog in server:" + client1.getHost() + " and port is:" + client1.getPort());
	        System.out.println("redis  in server:" + client2.getHost() + " and port is:" + client2.getPort());
	        System.out.println("test   in server:" + client3.getHost() + " and port is:" + client3.getPort());
	        System.out.println("123456 in server:" + client4.getHost() + " and port is:" + client4.getPort());  
			
			
		} finally {
			// ʹ�ú�һ���رգ��������ӳ�
			if (shardedJedis != null) {
				shardedJedis.close();
			}
		}
	}
	
	public static void main(String[] args) {
		new ShardedJedisTest().op();
	}

}
