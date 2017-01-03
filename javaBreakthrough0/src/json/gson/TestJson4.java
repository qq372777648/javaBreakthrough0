package json.gson;

import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;

/**   
* @author lzw   
* @date 2016年8月24日 上午11:09:03 
* @Description: 
* @version V1.0   
*/
public class TestJson4 {
	public static void main(String[] args) {
		String result="{\"status\": \"True\", \"docName\": [\"testAlbum\", \"testAlbum2\"]}";
		
	
		
		
		Gson gson =new Gson();
		Map<String,Object> map=gson.fromJson(result,Map.class);
		for (String key:map.keySet()) {
			System.out.println(map.get(key));
			
		}
		System.out.println(((ArrayList)map.get("docName")).get(0));
	}

}
