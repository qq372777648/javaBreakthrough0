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
		 MemCachedClient.mcc.flushAll(); //清空 
		 
		 if(true)
			 return;
		
		
//		MemCachedClient cache=new MemCachedClient();
		
//		System.out.println(MemCachedClient.get("re6590-1455763978472"));
//		
		String t=(String)MemCachedClient.get("re6590-145576397847299000");
		System.out.println(t);
		
//		for (int i = 100000; i < 1000000; i++) {
//			String key="re6590-1455763978472"+i;
//			MemCachedClient.add(key, t,new Date(60*60*1000));
//		}
//		
		
		for (int i = 0; i <10; i++) {
			String key="re6590-1455763978472"+i;
//			MemCachedClient.add(key, "3245",new Date(30*60*1000));
		}
		
		System.out.println((String)MemCachedClient.get("re6590-145576397847299000"));
//												re6590-1455763978472
		
//		System.out.println(MemCachedClient.get("key9"));
//		long s=System.currentTimeMillis();
//		System.out.println(MemCachedClient.get("key"));
//		System.out.println(System.currentTimeMillis()-s);
//		s=System.currentTimeMillis();
//		System.out.println(MemCachedClient.get("key"));
//		System.out.println(System.currentTimeMillis()-s);
//		
//		String re=null;
//		if( (re=(String)MemCachedClient.get("key"))!=null)
//			System.out.println(re);;
		
		
		try {
//            MemCachedClient.add("key", "1xxfrist blood2", new Date(10*60*1000)); //put to memcached as distribute cache to sycn multiple servers.
//            MemCachedClient.add("key1", "2xxfrist blood2", new Date(10*60*1000));
//            MemCachedClient.add("key2", "3xxfrist blood2", new Date(10*60*1000));
//            MemCachedClient.add("key3", "4xxfrist blood2", new Date(10*60*1000));
//			MemCachedClient.add("key9", "9xxfrist blood2", new Date(10*60*1000));
            
		} catch (Exception e1) {
        }
//		 String msg = (String) MemCachedClient.get("1461556049321");
//		 System.out.println(msg);
//		 MemCachedClient.del("1461556049321");
//		 System.out.println(MemCachedClient.get("1461556049321"));
		
//		 String[] keys = { "key9", "key1", "key2" };  
//		 Map values = MemCachedClient.mcc.getMulti(keys); 
//		 for(Object value:values.values()){
//			 System.out.println(value);
//		 }
		 
//		 MemCachedClient.mcc.flushAll(); //清空 
//		 MemCachedClient.mcc.set("key", "doubi");
//		 System.out.println(MemCachedClient.get("key"));
		
		 
	}

}

