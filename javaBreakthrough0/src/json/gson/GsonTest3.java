package json.gson;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/** 
* @author lzw 
* @version 创建时间：2016年7月13日 上午9:23:06 
* @Description:  
*/
public class GsonTest3 {
	public static void main(String[] args) {
		
		
		String str="{\"1451592342631\": 56 }";
		Gson gson =new Gson();
		Map map=gson.fromJson(str,Map.class);
		System.out.println(map.get("1451592342631"));
		System.out.println("-"+str.substring(str.indexOf(':')+1,str.length()-1)+"-");
		System.out.println(Integer.parseInt(str.substring(str.indexOf(':')+1,str.length()-1).trim()));
		
		
	}

}

