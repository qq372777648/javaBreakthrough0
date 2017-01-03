/** 
* @author lzw 
* @version 创建时间：2016年7月15日 上午11:19:34 
* @Description:  
*/
public class tests {
	public static void main(String[] args) {
		
		System.out.println(true&true);
		System.out.println(false&false);
		System.out.println(true&false);
		
		
		
		System.out.println(new String[0].length);
		String arr[]="".split(";");
		System.out.println(arr.length); //1
		System.out.println("".equals(arr[0]));
		if(true)
			return;
		
		
		String arr2[]=";x".split(";");
		System.out.println(arr2.length); //2
		System.out.println("".equals(arr2[0]));
		
		
		String arr3[]="x;".split(";");
		System.out.println(arr3.length); //1
		
		arr3="x; ".split(";");
		System.out.println(arr3.length); //2
		
		arr3=";".split(";");
		System.out.println(arr3.length); //0
		//System.out.println("".equals(arr3[0]));//error
		
		arr3="china".split(",");//1
		System.out.println(arr3.length);
		
		
		
	}

}

