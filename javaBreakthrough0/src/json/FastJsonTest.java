package json;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @author lzw
 * @version 创建时间：2016年6月21日 上午9:48:54
 * @Description:
 */
public class FastJsonTest {
	public static void main(String[] args) {
		BeanA a=new BeanA();
		a.setId(243);
		a.setText("doubi");
		System.out.println(JSON.toJSONString(a));
		
		List<BeanA>  list=new ArrayList<>();
		list.add(a);
		BeanA a2=new BeanA();
		a2.setId(2433);
		a2.setText("doubi2");
		list.add(a2);
		System.out.println(JSON.toJSONString(list));
		
		Map<String, BeanA> map=new LinkedHashMap<String, BeanA>();
		map.put("1", a);
		map.put("2", a2);
		System.out.println(JSON.toJSONString(map));
		
		Map<String, List<BeanA>> maplist=new LinkedHashMap<String, List<BeanA>>();
		maplist.put("1", list);
		List<BeanA>  list2=new ArrayList<>();
		list2.add(new BeanA(1,"w45"));
		list2.add(new BeanA(2,"lksfd"));
		maplist.put("2", list2);
		System.out.println(JSON.toJSONString(maplist));
		
		
		System.out.println("---------------to bean");
		String json="{\"id\":243,\"text\":\"doubi\",\"sdf\":2134}";
		BeanA aa=JSON.parseObject(json, BeanA.class);
		System.out.println(aa);
		
		System.out.println("---------------to map");
		String jsonmaps="{\"1\":{\"id\":243,\"text\":\"doubi\"},\"2\":{\"id\":2433,\"text\":\"doubi2\"}}";
		Map<String, BeanA> mapJson=JSON.parseObject(jsonmaps, new TypeReference<Map<String, BeanA>>() {});
		for (String key:mapJson.keySet()) {
			System.out.println(mapJson.get(key));
			
		}
		
		System.out.println("---------------to arr");
		String jsons="[{\"id\":243,\"text\":\"doubi\",\"text2\":\"doubi222\"},{\"id\":2433,\"text\":\"doubi2\"}]";
		//BeanA[] arr=FastJSONHelper.deserialize(jsons, BeanA[].class);
		BeanA[] arr=JSON.parseObject(jsons, BeanA[].class);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		//BeanA[] arr=(BeanA[])JSON.parseObject(json, BeanA[].class);
//		BeanA[] arr=JSON.parseArray(json, BeanA[].class);

		System.out.println("---------------to list");
		List<BeanA> jsonList=JSON.parseObject(jsons, new TypeReference<List<BeanA> >() {});
		for (BeanA aaaa:jsonList) {
			System.out.println(aaaa);
			
		}

	}

}
