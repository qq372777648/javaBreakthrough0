
package jedis_test.util;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zdc
 * @since 2015��6��9��
 */
public class JedisUtils {


    /**
     * ˽�й�����.
     * 
     * @return
     */
    @SuppressWarnings("unused")
    private void JedisUtil() {

    }

    private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();

    /**
     * ��ȡ���ӳ�.
     * 
     * @return ���ӳ�ʵ��
     */
    private static JedisPool getPool(String ip, int port) {
        String key = ip + ":" + port;
        JedisPool pool = null;
        // int i=2;
        if (!maps.containsKey(key)) {

            try {
                /**
                 * ��������� java.net.SocketTimeoutException: Read timed out exception���쳣��Ϣ
                 *  �볢���ڹ���JedisPool��ʱ�������Լ��ĳ�ʱֵ.
                 * JedisPoolĬ�ϵĳ�ʱʱ����2��(��λ����) JedisPoolConfig
                 */
                JedisPoolConfig poolConfig = new JedisPoolConfig();
                poolConfig.setMaxTotal(1024);
                poolConfig.setMaxIdle(200);
                poolConfig.setMaxWaitMillis(1000);
                poolConfig.setTestOnBorrow(true);
                
                pool = new JedisPool(poolConfig, ip, port, 2000);
                maps.put(key, pool);
            } catch (Exception e) {
            }
        } else {
            pool = maps.get(key);
        }
        return pool;
    }

    /**
     * �༶���ڲ��࣬Ҳ���Ǿ�̬�ĳ�Աʽ�ڲ��࣬���ڲ����ʵ�����ⲿ���ʵ�� û�а󶨹�ϵ������ֻ�б����õ�ʱ�Ż�װ�أ��Ӷ�ʵ�����ӳټ��ء�
     */
    private static class RedisUtilHolder {

        /**
         * ��̬��ʼ��������JVM����֤�̰߳�ȫ
         */
        private static JedisUtils instance = new JedisUtils();
    }

    /**
     * ��getInstance������һ�α����õ�ʱ������һ�ζ�ȡ RedisUtilHolder.instance��
     * ����RedisUtilHolder��õ���ʼ�������������װ�ز�����ʼ����ʱ�򣬻��ʼ�����ľ�
     * ̬�򣬴Ӷ�����JedisUtil��ʵ����
     * �����Ǿ�̬�������ֻ���������װ�����ʱ���ʼ��һ�Σ��������������֤�����̰߳�ȫ�ԡ�
     * ���ģʽ���������ڣ�getInstance������û�б�ͬ��������ֻ��ִ��һ����ķ��ʣ�����ӳٳ�ʼ����û�������κη��ʳɱ���
     */
    public static JedisUtils getInstance() {
        return RedisUtilHolder.instance;
    }

    /**
     * ��ȡRedisʵ��.
     * 
     * @return Redis������ʵ��
     */
    @SuppressWarnings("deprecation")
    public Jedis getJedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        do {
            try {
                jedis = getPool(ip, port).getResource();
                // log.info("get redis master1!");
            } catch (Exception e) {
                // ���ٶ���
                getPool(ip, port).returnBrokenResource(jedis);
            }
            count++;
        } while (jedis == null && count < 5);
        return jedis;
    }

    /**
     * �ͷ�redisʵ�������ӳ�.
     * 
     * @param jedis
     *            redisʵ��
     */
    public void closeJedis(Jedis jedis, String ip, int port) {
        if (jedis != null) {
            getPool(ip, port).returnResourceObject(jedis);
        }
    }
}
