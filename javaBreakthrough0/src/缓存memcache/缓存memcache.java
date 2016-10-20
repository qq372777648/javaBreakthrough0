package 缓存memcache;

import java.util.Date;
import java.util.Map;

/** 
* @author lzw 
* @version 创建时间：2016年7月5日 下午3:23:46 
* @Description:  
*/
public class 缓存memcache {
	public static void main(String[] args) {
//		MemCachedClient cache=new MemCachedClient();
		try {
//            MemCachedClient.add("key", "1xxfrist blood2", new Date(10*60*1000)); //put to memcached as distribute cache to sycn multiple servers.
//            MemCachedClient.add("key1", "2xxfrist blood2", new Date(10*60*1000));
//            MemCachedClient.add("key2", "3xxfrist blood2", new Date(10*60*1000));
//            MemCachedClient.add("key3", "4xxfrist blood2", new Date(10*60*1000));
			MemCachedClient.add("key9", "9xxfrist blood2", new Date(10*60*1000));
            
		} catch (Exception e1) {
        }
//		 String msg = (String) MemCachedClient.get("1461556049321");
//		 System.out.println(msg);
//		 MemCachedClient.del("1461556049321");
//		 System.out.println(MemCachedClient.get("1461556049321"));
		 String[] keys = { "key9", "key1", "key2" };  
		 Map values = MemCachedClient.mcc.getMulti(keys); 
		 for(Object value:values.values()){
			 System.out.println(value);
		 }
		 
//		 MemCachedClient.mcc.flushAll(); //清空 
		 MemCachedClient.mcc.set("key", "doubi");
		 System.out.println(MemCachedClient.get("key"));
		
		 
	}

}

