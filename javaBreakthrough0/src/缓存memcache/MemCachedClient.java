package ����memcache;
import java.util.Date;

import com.danga.MemCached.SockIOPool;


public class MemCachedClient {

        // ����ȫ�ֵ�Ψһʵ��
        protected static com.danga.MemCached.MemCachedClient mcc;        
        // �����뻺������������ӳ�
        static {
            
            mcc= new com.danga.MemCached.MemCachedClient();
            
            // �������б����Ȩ��
            String[] servers ={"120.25.220.137:11211"};//{"192.168.1.52:11211","192.168.1.52:10000"};//�ֲ�ʽ��������ַ default port��11211
            Integer[] weights = {3};

            // ��ȡsocke���ӳص�ʵ������
            SockIOPool pool = SockIOPool.getInstance();

            // ���÷�������Ϣ
            pool.setServers( servers );
            pool.setWeights( weights );

            // ���ó�ʼ����������С������������Լ������ʱ��
            pool.setInitConn( 5 );
            pool.setMinConn( 5 );
            pool.setMaxConn( 250 );
            pool.setMaxIdle( 1000 * 60 * 60 * 6 );

            // �������̵߳�˯��ʱ��
            pool.setMaintSleep( 30 );

            // ����TCP�Ĳ��������ӳ�ʱ��
            pool.setNagle( false );
            pool.setSocketTO( 3000 );
            pool.setSocketConnectTO( 0 );

            // ��ʼ�����ӳ�
            pool.initialize();

        }
        
        
        /**
         * ���һ��ָ����ֵ��������.
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
         * ����ָ���Ĺؼ��ֻ�ȡ����.
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
