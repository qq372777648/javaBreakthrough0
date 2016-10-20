package 算法;
/** 
* @author lzw 
* @version 创建时间：2016年7月12日 下午1:10:42 
* @Description:  
*/

public class 全排列非递归 {
	static String str = "123";
	static char[] a = str.toCharArray();
	static int n = 3;
	static void swap(int arg1, int arg2){
		char temp;
		temp = a[arg1];
		a[arg1] = a[arg2];
		a[arg2] = temp;
	}
	static void  sort(int index){
		int i;
		if (index == n){
			for (i = 0; i < n; i++){
				System.out.print(a[i]);               
			}
				System.out.println("");
				return;
		}
		for (i = index; i < n; i++){
			swap(index,i);
			sort(index + 1);
			swap(index,i);
		}
	}
	public static void main(String args[]){
		for(int s =0;s<n;s++){
			sort(s);	
		}
	}
}