package json.gson;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**   
* @author lzw   
* @date 2016年11月8日 下午4:17:10 
* @Description: 
* @version V1.0   
*/
public class GsonTest5 {
	public static void main(String[] args) {
		String result=
		"{\"code\": \"SUCCESS\","+
			"\"data\": {"+
	        "\"abtag\": \"content_cf\","+
	        "\"trace_id\": \"you_love#content_cf#0b802c5714785892530752662e\","+
	        "\"rec\": ["+
	        "    ["+
	        "        \"1368193313183\","+
	        "        \"1.0\","+
	        "        \"老歌集 - 吕珊\""+
	        "    ],"+
	        "    ["+
	        "        \"1367132256498\","+
	        "        \"0.978723\","+
	        "        \"吕珊精选 - 吕珊\""+
	        "    ]  ]"+
    "},"+
    "\"message\": null,"+
    "\"rid\": \"0b802c5714785892530752662e\""+
	"}";
		
		Gson gson =new Gson();
		Map<String,Object> map=gson.fromJson(result,Map.class);
		for (String key:map.keySet()) {
			System.out.println(key+"----");
			System.out.println(map.get(key));
			
		}
		
//		map.get("data")
//		rec=[[1368193313183, 1.0, 老歌集 - 吕珊]
		List<List> list= (List<List>)((Map)map.get("data")).get("rec");
		for (int i = 0; i < 3&&i<list.size(); i++) {
			System.out.println(list.get(i).get(0));
		}
		
		
	}

}
