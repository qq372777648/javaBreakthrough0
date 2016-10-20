package json.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author lzw
 * @version 创建时间：2016年7月12日 下午12:26:58
 * @Description:
 */
public class GsonTest2 {

	public static void main(String[] args) {
		List<List> list=new ArrayList<>();
		List items1=new ArrayList<>();
		items1.add("牛逼");items1.add("牛排");
		List items2=new ArrayList<>();
		items2.add("装逼");items2.add("猪排");
		list.add(items1);list.add(items2);
		
		String str="[[\"北京天凡文化发展有限责任公司\",209],[\"\u5929\u7f51\",145]]";
		Gson gson =new Gson();
		System.out.println(gson.toJson(list));
		List<List<String>> list2=gson.fromJson(str,List.class);
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i));
		}
	}
}
