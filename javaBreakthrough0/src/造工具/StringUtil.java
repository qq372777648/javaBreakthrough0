package �칤��;

/**   
* @author lzw   
* @date 2016��9��1�� ����11:04:30 
* @Description: 
* @version V1.0   
*/
public class StringUtil {
	
	public static String  delCN(String str){
		String str0="";
		for (int i = 0; i < str.length(); i++){
			if (str.substring(i, i + 1).matches("[u4e00-u9fa5]+")){
				str0 = str0+str.substring(i, i + 1);
			}
			}
		return str0;	
	}
	
	

}
