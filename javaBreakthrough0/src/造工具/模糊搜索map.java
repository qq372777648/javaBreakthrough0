package �칤��;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��17�� ����6:10:32 
* @Description:  
*/
public class ģ������map {

	public static void main(String[] args) {
	    Map map=new HashMap(); 
	    map.put("liangzhenwei","1993");
	    map.put("liangzenwei","1994");
	    map.put("liangzheng","1995");
	    map.put("liangzhe","1996");
	    List<String> result = likeString("zhen", map);
	    for(String value:result)
	    	System.out.println(value);
	}
	     
	     
	public static List<String> likeString(String key, Map<String, Book> map) {
	    List list = new ArrayList();
	    Iterator it = map.entrySet().iterator();
	    while(it.hasNext()) {
	        Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
	        if (entry.getKey().indexOf(key) != -1) {
	            list.add(entry.getValue());
	        }
	    }
	    return list;
	}
}

