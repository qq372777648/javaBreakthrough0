package 缓存memcache;
import java.util.Date;

import com.danga.MemCached.SockIOPool;


public class MemCachedClient {

        // 创建全局的唯一实例
        protected static com.danga.MemCached.MemCachedClient mcc;        
        // 设置与缓存服务器的连接池
        static {
            
            mcc= new com.danga.MemCached.MemCachedClient();
            
            // 服务器列表和其权重
            String[] servers ={"120.25.220.137:11211"};//{"192.168.1.52:11211","192.168.1.52:10000"};//分布式服务器地址 default port；11211
            Integer[] weights = {3};

            // 获取socke连接池的实例对象
            SockIOPool pool = SockIOPool.getInstance();

            // 设置服务器信息
            pool.setServers( servers );
            pool.setWeights( weights );

            // 设置初始连接数、最小和最大连接数以及最大处理时间
            pool.setInitConn( 5 );
            pool.setMinConn( 5 );
            pool.setMaxConn( 250 );
            pool.setMaxIdle( 1000 * 60 * 60 * 6 );

            // 设置主线程的睡眠时间
            pool.setMaintSleep( 30 );

            // 设置TCP的参数，连接超时等
            pool.setNagle( false );
            pool.setSocketTO( 3000 );
            pool.setSocketConnectTO( 0 );

            // 初始化连接池
            pool.initialize();

        }
        
        
        /**
         * 添加一个指定的值到缓存中.
         * @param key
         * @param value
         * @return
         */
        public static boolean add(String key, Object value)
        {
            return mcc.add(key, value);
        }
        
        public static boolean add(String key, Object value, Date expiry)
        {
            return mcc.add(key, value, expiry);
        }
        
        public static boolean replace(String key, Object value)
        {
            return mcc.replace(key, value);
        }
        
        public static boolean replace(String key, Object value, Date expiry)
        {
            return mcc.replace(key, value, expiry);
        }
        
        /**
         * 根据指定的关键字获取对象.
         * @param key
         * @return
         */
        public static Object get(String key)
        {
            return mcc.get(key);
        }
        
        public static void del(String key){
        	mcc.delete(key);  
        }
}
