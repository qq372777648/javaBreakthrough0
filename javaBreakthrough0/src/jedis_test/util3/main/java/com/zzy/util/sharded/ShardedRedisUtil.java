package com.zzy.util.sharded;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;

/**
 * 鍒嗙墖redis
 * 
 * @author zhengzhiyuan
 * @since May 20, 2016
 */
public class ShardedRedisUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShardedRedisUtil.class);

    private static final String DEFAULT_REDIS_SEPARATOR = ";";

    private static final String HOST_PORT_SEPARATOR = ":";

    private ShardedJedisPool shardedJedisPool = null;

    private static final ShardedRedisUtil INSTANCE = new ShardedRedisUtil();

    private ShardedRedisUtil() {
        initialShardedPool();
    }

    private void initialShardedPool() {
        // 鎿嶄綔瓒呮椂鏃堕棿,榛樿2绉�        int timeout = NumberUtils.toInt(SharedRedisConfig.getConfigProperty("redis.timeout"), 2000);
        // jedis姹犳渶澶ц繛鎺ユ暟鎬绘暟锛岄粯璁�
        int maxTotal = NumberUtils.toInt(SharedRedisConfig.getConfigProperty("redis.jedisPoolConfig.maxTotal"), 8);
        // jedis姹犳渶澶х┖闂茶繛鎺ユ暟锛岄粯璁�
        int maxIdle = NumberUtils.toInt(SharedRedisConfig.getConfigProperty("redis.jedisPoolConfig.maxIdle"), 8);
        // jedis姹犳渶灏戠┖闂茶繛鎺ユ暟
        int minIdle = NumberUtils.toInt(SharedRedisConfig.getConfigProperty("redis.jedisPoolConfig.minIdle"), 0);
        // jedis姹犳病鏈夊璞¤繑鍥炴椂锛屾渶澶х瓑寰呮椂闂村崟浣嶄负姣
        long maxWaitMillis = NumberUtils.toLong(SharedRedisConfig.getConfigProperty("redis.jedisPoolConfig.maxWaitTime"), -1);
        // 鍦╞orrow涓�釜jedis瀹炰緥鏃讹紝鏄惁鎻愬墠杩涜validate鎿嶄綔
        boolean testOnBorrow = Boolean.parseBoolean(SharedRedisConfig.getConfigProperty("redis.jedisPoolConfig.testOnBorrow"));

        // 璁剧疆jedis杩炴帴姹犻厤缃�        
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        poolConfig.setTestOnBorrow(testOnBorrow);

        // 鍙栧緱redis鐨剈rl
        String redisUrls = SharedRedisConfig.getConfigProperty("redis.jedisPoolConfig.urls");
        if (redisUrls == null || redisUrls.trim().isEmpty()) {
            throw new IllegalStateException("the urls of redis is not configured");
        }
        LOGGER.info("the urls of redis is {}", redisUrls);

        // 鐢熸垚杩炴帴姹�        List<JedisShardInfo> shardedPoolList = new ArrayList<JedisShardInfo>();
        for (String redisUrl : redisUrls.split(DEFAULT_REDIS_SEPARATOR)) {
            String[] redisUrlInfo = redisUrl.split(HOST_PORT_SEPARATOR);
            JedisShardInfo Jedisinfo = new JedisShardInfo(redisUrlInfo[0], Integer.parseInt(redisUrlInfo[1]), timeout);
            shardedPoolList.add(Jedisinfo);
        }

        // 鏋勯�姹�        this.shardedJedisPool = new ShardedJedisPool(poolConfig, shardedPoolList, Hashing.MURMUR_HASH);
    }

    public static ShardedRedisUtil getInstance() {
        return INSTANCE;
    }

    /**
     * 瀹炵幇jedis杩炴帴鐨勮幏鍙栧拰閲婃斁锛屽叿浣撶殑redis涓氬姟閫昏緫鐢眅xecutor瀹炵幇
     * 
     * @param executor RedisExecutor鎺ュ彛鐨勫疄鐜扮被
     * @return
     */
    public <T> T execute(String key, ShardedRedisExecutor<T> executor) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        T result = null;
        try {
            result = executor.execute(jedis);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return result;
    }

    public String set(final String key, final String value) {
        return execute(key, new ShardedRedisExecutor<String>() {
            @Override
            public String execute(ShardedJedis jedis) {
                return jedis.set(key, value);
            }
        });
    }

    public String set(final String key, final String value, final String nxxx, final String expx, final long time) {
        return execute(key, new ShardedRedisExecutor<String>() {
            @Override
            public String execute(ShardedJedis jedis) {
                return jedis.set(key, value, nxxx, expx, time);
            }
        });
    }

    public String get(final String key) {
        return execute(key, new ShardedRedisExecutor<String>() {
            @Override
            public String execute(ShardedJedis jedis) {
                return jedis.get(key);
            }
        });
    }

    public Boolean exists(final String key) {
        return execute(key, new ShardedRedisExecutor<Boolean>() {
            @Override
            public Boolean execute(ShardedJedis jedis) {
                return jedis.exists(key);
            }
        });
    }

    public Long setnx(final String key, final String value) {
        return execute(key, new ShardedRedisExecutor<Long>() {
            @Override
            public Long execute(ShardedJedis jedis) {
                return jedis.setnx(key, value);
            }
        });
    }

    public String setex(final String key, final int seconds, final String value) {
        return execute(key, new ShardedRedisExecutor<String>() {
            @Override
            public String execute(ShardedJedis jedis) {
                return jedis.setex(key, seconds, value);
            }
        });
    }

    public Long expire(final String key, final int seconds) {
        return execute(key, new ShardedRedisExecutor<Long>() {
            @Override
            public Long execute(ShardedJedis jedis) {
                return jedis.expire(key, seconds);
            }
        });
    }

    public Long incr(final String key) {
        return execute(key, new ShardedRedisExecutor<Long>() {
            @Override
            public Long execute(ShardedJedis jedis) {
                return jedis.incr(key);
            }
        });
    }

    public Long decr(final String key) {
        return execute(key, new ShardedRedisExecutor<Long>() {
            @Override
            public Long execute(ShardedJedis jedis) {
                return jedis.decr(key);
            }
        });
    }

    public Long hset(final String key, final String field, final String value) {
        return execute(key, new ShardedRedisExecutor<Long>() {
            @Override
            public Long execute(ShardedJedis jedis) {
                return jedis.hset(key, field, value);
            }
        });
    }

    public String hget(final String key, final String field) {
        return execute(key, new ShardedRedisExecutor<String>() {
            @Override
            public String execute(ShardedJedis jedis) {
                return jedis.hget(key, field);
            }
        });
    }

    public String hmset(final String key, final Map<String, String> hash) {
        return execute(key, new ShardedRedisExecutor<String>() {
            @Override
            public String execute(ShardedJedis jedis) {
                return jedis.hmset(key, hash);
            }
        });
    }

    public List<String> hmget(final String key, final String... fields) {
        return execute(key, new ShardedRedisExecutor<List<String>>() {
            @Override
            public List<String> execute(ShardedJedis jedis) {
                return jedis.hmget(key, fields);
            }
        });
    }

    public Long del(final String key) {
        return execute(key, new ShardedRedisExecutor<Long>() {
            @Override
            public Long execute(ShardedJedis jedis) {
                return jedis.del(key);
            }
        });
    }

    public Map<String, String> hgetAll(final String key) {
        return execute(key, new ShardedRedisExecutor<Map<String, String>>() {
            @Override
            public Map<String, String> execute(ShardedJedis jedis) {
                return jedis.hgetAll(key);
            }
        });
    }

    public void destroy() {
        this.shardedJedisPool.close();
    }
}
