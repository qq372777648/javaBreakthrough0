package core.stringbf;

/**   
* @author lzw   
* @date 2016年9月7日 下午4:02:24 
* @Description: 
* @version V1.0   
*/
public class delete {
	public static void main(String[] args) {
		StringBuffer sb= new StringBuffer();
		for (int i = 1; i < 3; i++) {
			sb.append("234");
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1); 
		System.out.println(sb.toString());
	}

}
