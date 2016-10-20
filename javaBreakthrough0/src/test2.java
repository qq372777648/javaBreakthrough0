import 造工具.StringUtil;

/**   
* @author lzw   
* @date 2016年9月1日 上午11:00:29 
* @Description: 
* @version V1.0   
*/
public class test2 {

	public static void main(String[] args) {
		System.out.println("".split(",wer,").length);
		
		
		String date="2016年第20周";
		System.out.println(date.substring(0,4));
		
		System.out.println(StringUtil.delCN(date.substring(4)));
		System.out.println("group119/M00/20/00/dEd0D3fc04b7378FB9f0ecfE2D2e0dFB.mp3".indexOf("/")+1);
		System.out.println("group119/M00/20/00/dEd0D3fc04b7378FB9f0ecfE2D2e0dFB.mp3".indexOf("/",9));
		System.out.println("group119/M00/20/00/dEd0D3fc04b7378FB9f0ecfE2D2e0dFB.mp3".substring(12));
		
	
	}
}
