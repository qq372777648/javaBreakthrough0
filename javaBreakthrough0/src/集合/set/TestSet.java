package ����.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��8��8�� ����2:40:49 
* @Description:  
*/
public class TestSet {

	public static void main(String[] args) {
		  Set<String> set = new HashSet<String>();//�����ظ�
		   set.add("a");
		   set.add("d");
		   set.add("d");
		   set.add("uuu");
		   set.add("e");
		   set.add("b");
		   set.add("c");
		   set.add("d");
		   set.add("d");
		  
		  
		   Iterator<String> it = set.iterator();
		   while (it.hasNext()) {
		    System.out.println(it.next());
		   }
		   
		   System.out.println("------------------");
		   Set<String> set2 = new TreeSet<String>();//�����ظ�
		   set2.add("a");
		   set2.add("d");
		   set2.add("d");
		   set2.add("uuu");
		   set2.add("e");
		   set2.add("b");
		   set2.add("c");
		   set2.add("d");
		   set2.add("d");
		  
		  
		   Iterator<String> it2 = set2.iterator();
		   while (it2.hasNext()) {
		    System.out.println(it2.next());
		   }
		   
	}

}

