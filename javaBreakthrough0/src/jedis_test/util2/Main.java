import jedis_test.util2.redis.NewsCategory;
import jedis_test.util2.redis.SerializableUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	RedisImpl redis = new RedisImpl();
		//if(redis.isConnected()){
			System.out.println(redis.set("testMyprogrammer", "valuevalue"));
			System.out.println(redis.get("testMyprogrammer"));
			
	//	}
	//	else
	//	{
		//	System.out.println("hehehe");
	//	}*/
		NewsCategory nc = new NewsCategory();
		nc.set("heheh");
		try {
			SerializableUtil.serializableToByteArray(nc);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
