package �ļ�����;
/** 
* @author lzw 
* @version ����ʱ�䣺2016��5��30�� ����2:15:25 
* @Description:  
*/
public class test3 {
	public static void main(String[] args) {
		byte key=100;
		String a="l����2b�����㷨";
		//����
		byte bs[]=a.getBytes();
		for (int i = 0; i < bs.length; i++) {
			System.out.println(bs[i]);
		}
		System.out.println("----����------------");
		for (int i = 0; i < bs.length; i++) {
			bs[i]^=key;
			System.out.println(bs[i]);
		}
		String b=new String(bs);
		System.out.println(b);
		
		
		
		System.out.println("-----����-----------");
		//����
		byte bs2[]=b.getBytes();
		for (int i = 0; i < bs2.length; i++) {
			bs2[i]^=key;
			System.out.println(bs2[i]);
		}
		System.out.println(new String(bs2));
	}

}

