import java.util.ArrayList;
import java.util.List;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��8��5�� ����6:29:59 
* @Description:  
*/
public class ListToArray {

	
	public static void main(String[] args) {
		List list0= new ArrayList();
		list0.add("1");
		list0.add("2");
		final int size =list0.size();
		String[] arr = (String[])list0.toArray(new String[size]);
		
//		if (true)
//			return;
		
		
		
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		if("track".equals(1)||"ablum".equals(1) ||"".equals(1)){
			list.add("�ײ�");
			list2.add("Name");
		}
		list.add("��������");
		list.add("����");
		list.add("����");
		list.add("���� ");
		list.add("��������");
		list.add("�����ɽ���(%)");
		list.add("����");
		
		
		list2.add("reportType");
		list2.add("reportDate");
		list2.add("channel");
		list2.add("count");
		list2.add("orderSum");
		list2.add("orderSuccessRate");
		list2.add("income");
		
		String[] headers=(String[])list.toArray(new String[list.size()]);
		String[] columKey=(String[])list2.toArray(new String[list2.size()]);
	}
}

