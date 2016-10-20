package jedis_test;

import java.util.List;

import redis.clients.jedis.Jedis;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��6��14�� ����4:57:51
 * @Description:
 */
public class jedisTest {
	//Jedis jedis=null;
	public static void main(String[] args) throws InterruptedException {
		//�ȴ�jedis������
				// ���ӱ��ص� Redis ����
		Jedis jedis = JedisUtil.getConnection();
		System.out.println("Connection to server sucessfully");
		// �鿴�����Ƿ�����
		System.out.println("Server is running: " + jedis.ping());
				
				//new jedisTest().testString(jedis);
//		while(true)
//			Thread.sleep(3000);
		System.out.println(System.currentTimeMillis());
//		System.out.println(jedis.get("name3456"));
//		 List<String> rsmap = jedis.hmget("user13656", "name");
//	       System.out.println(rsmap);
		jedis.select(2);
		jedis.set("name","��Ψ");
//		jedis.quit();
//        jedis.close();
		
		System.out.println(System.currentTimeMillis());
//		for(int i=0;i<5000000;i++){
//			jedis.set("name"+i,"����"+i);
//			
//			 Map map = new HashMap();
//		       map.put("name", "22"+i);
//		       map.put("age", "22"+i);
//		       map.put("qq", "22"+i);
//		       jedis.hmset("user"+i,map);
//		}
		System.out.println(System.currentTimeMillis());
	}
	
////	����1.redis�洢�ַ���
//	//   @Test
	   public  void testString(Jedis jedis) {
	       //-----�������----------
	       jedis.set("name","����");//��key-->name�з�����value--xinxin
	       System.out.println(jedis.get("name"));//ִ�н����xinxin
	       jedis.append("name", " is my lover"); //ƴ��
	       System.out.println(jedis.get("name"));
	       
	       jedis.del("name");  //ɾ��ĳ����
	       System.out.println(jedis.get("name"));
	       
	       //���ö����ֵ��
	       jedis.mset("name","liuling","age","23","qq","476777XXX");
	       System.out.println(jedis.get("age"));
	       jedis.incr("age"); //���м�1����
	       System.out.println(jedis.get("age"));
	       System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
	   }
////	����2.redis����Map
////	    @Test
//	   public static void testMap() {
//	       //-----�������----------
//	       Map<String, String> map = new HashMap<String, String>();
//	       map.put("name", "xinxin");
//	       map.put("age", "22");
//	       map.put("qq", "123456");
//	       jedis.hmset("user",map);
//	       //ȡ��user�е�name��ִ�н��:[minxr]-->ע������һ�����͵�List
//	       //��һ�������Ǵ���redis��map�����key����������Ƿ���map�еĶ����key�������key���Ը�������ǿɱ����
//	       List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
//	       System.out.println(rsmap);
//	       //ɾ��map�е�ĳ����ֵ
//	       jedis.hdel("user","age");
//	       System.out.println(jedis.hmget("user", "age")); //��Ϊɾ���ˣ����Է��ص���null
//	       System.out.println(jedis.hlen("user")); //����keyΪuser�ļ��д�ŵ�ֵ�ĸ���2
//	       System.out.println(jedis.exists("user"));//�Ƿ����keyΪuser�ļ�¼ ����true
//	       System.out.println(jedis.hkeys("user"));//����map�����е�����key
//	       System.out.println(jedis.hvals("user"));//����map�����е�����value
//	       Iterator<String> iter=jedis.hkeys("user").iterator();
//	       while (iter.hasNext()){
//	           String key = iter.next();
//	           System.out.println(key+":"+jedis.hmget("user",key));
//	       }
//	   }
////	����3.jedis����List
////	    @Test
//	   public void testList(){
//	       //��ʼǰ�����Ƴ����е�����
//	       jedis.del("java framework");
//	       System.out.println(jedis.lrange("java framework",0,-1));
//	       //����key java framework�д����������
//	       jedis.lpush("java framework","spring");
//	       jedis.lpush("java framework","struts");
//	       jedis.lpush("java framework","hibernate");
//	       //��ȡ����������jedis.lrange�ǰ���Χȡ����
//	       // ��һ����key���ڶ�������ʼλ�ã��������ǽ���λ�ã�jedis.llen��ȡ���� -1��ʾȡ������
//	       System.out.println(jedis.lrange("java framework",0,-1));
//	       jedis.del("java framework");
//	       jedis.rpush("java framework","spring");
//	       jedis.rpush("java framework","struts");
//	       jedis.rpush("java framework","hibernate");
//	       System.out.println(jedis.lrange("java framework",0,-1));
//	   }
//	//����4. jedis����Set
////    @Test
//   public void testSet(){
//       jedis.del("user");
//       //���
//       jedis.sadd("user","liuling");
//       jedis.sadd("user","xinxin");
//       jedis.sadd("user","ling");
//       jedis.sadd("user","zhangxinxin");
//       jedis.sadd("user","who");
//       //�Ƴ�noname
//       jedis.srem("user","who");
//       System.out.println(jedis.smembers("user"));//��ȡ���м����value
//       System.out.println(jedis.sismember("user", "xinxin"));//�ж� who �Ƿ���user���ϵ�Ԫ��
//       System.out.println(jedis.srandmember("user")); //�������һ��user��Ԫ�ص�value
//       System.out.println(jedis.scard("user"));//���ؼ��ϵ�Ԫ�ظ���
//   } 
//	  
//	  //5.jedis ����
//	   public void test() throws InterruptedException {
//	       //
//	       //ע�⣬�˴���rpush��lpush��List�Ĳ�������һ��˫���������ӱ��������ģ�
//	       jedis.del("a");//��������ݣ��ټ������ݽ��в���
//	       jedis.rpush("a", "1");
//	       jedis.lpush("a","6");
//	       jedis.lpush("a","3");
//	       jedis.lpush("a","9");
//	       System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]
//	       System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //�����������
//	       System.out.println(jedis.lrange("a",0,-1));
//	   }
//	
//	

}
