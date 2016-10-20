package 造工具;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/** 
* @author lzw 
* @version 创建时间：2016年8月4日 上午10:35:03 
* @Description:  
*/
public class MapUtil {

	public static void main(String[] args) {
		LinkedHashMap map0=new LinkedHashMap(){
			{
				put("a","aaa");
				put("b","bbb");
				put("c","ccc");
			}
		};
		LinkedHashMap map=new LinkedHashMap();
		map.putAll(map0);//copy all
		for (Object key:map.keySet()) {
			System.out.println(map.get(key));
		}
		
		map0.put("c", "ddd");
		for (Object key:map.keySet()) {
			System.out.println(map.get(key));
		}
		for (Object key:map0.keySet()) {
			System.out.println(map0.get(key));
		}
	}
	
	
	
	/**
	 * 返回合并后的新map 
	 * @param map
	 * @param map2
	 * @return map3=map+map2
	 */
	public  static Map concat2(Map map,Map map2){
		Map newMap=new HashMap();
		if(!isNull(map)){
			Set<String> keySet=map.keySet();
			for (String key : keySet) {
				newMap.put(key, map.get(key));
			}
		}
		if(!isNull(map2)){
			Set<String> keySet=map2.keySet();
			for (String key : keySet) {
				newMap.put(key, map2.get(key));
			}
		}
		return newMap;
		
	}
	/**
	 * @Title: isNull
	 * @Description: 判断map是否为空
	 * @param @param map
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isNull(Map<?, ?> map) {
		return map == null || map.size() <= 0;
	}
}

