package json.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��7��12�� ����12:26:58
 * @Description:
 */
public class GsonTest2 {

	public static void main(String[] args) {
		List<List> list=new ArrayList<>();
		List items1=new ArrayList<>();
		items1.add("ţ��");items1.add("ţ��");
		List items2=new ArrayList<>();
		items2.add("װ��");items2.add("����");
		list.add(items1);list.add(items2);
		
		String str="[[\"�����췲�Ļ���չ�������ι�˾\",209],[\"\u5929\u7f51\",145]]";
		Gson gson =new Gson();
		System.out.println(gson.toJson(list));
		List<List<String>> list2=gson.fromJson(str,List.class);
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i));
		}
	}
}
