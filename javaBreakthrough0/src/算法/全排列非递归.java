package �㷨;
/** 
* @author lzw 
* @version ����ʱ�䣺2016��7��12�� ����1:10:42 
* @Description:  
*/

public class ȫ���зǵݹ� {
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