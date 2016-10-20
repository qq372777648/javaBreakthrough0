package 类型转换;
/** 
* @author lzw 
* @version 创建时间：2016年8月5日 上午10:50:11 
* @Description:  
*/
public class test {
	public static void main(String[] args) {
		int t1=4;
		int t2=9;
		System.out.println((double)(t1-t2)/t2);
		 double d=((double)(t1-t2)/t2)*100; 
		 System.out.println((Math.round(d*100)/100.0));
		
		
	}

}

