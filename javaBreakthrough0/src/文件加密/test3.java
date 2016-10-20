package 文件加密;
/** 
* @author lzw 
* @version 创建时间：2016年5月30日 下午2:15:25 
* @Description:  
*/
public class test3 {
	public static void main(String[] args) {
		byte key=100;
		String a="l逗逼2b加密算法";
		//加密
		byte bs[]=a.getBytes();
		for (int i = 0; i < bs.length; i++) {
			System.out.println(bs[i]);
		}
		System.out.println("----加密------------");
		for (int i = 0; i < bs.length; i++) {
			bs[i]^=key;
			System.out.println(bs[i]);
		}
		String b=new String(bs);
		System.out.println(b);
		
		
		
		System.out.println("-----解密-----------");
		//解密
		byte bs2[]=b.getBytes();
		for (int i = 0; i < bs2.length; i++) {
			bs2[i]^=key;
			System.out.println(bs2[i]);
		}
		System.out.println(new String(bs2));
	}

}

