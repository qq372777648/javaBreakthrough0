package ����ǩ��;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��5��31�� ����11:26:16
 * @Description:
 */
public class _1ժҪ {
	public static void main(String[] args)  {
		try {
			
			byte[] plainText = "123".getBytes("UTF8");
			// ʹ��getInstance("�㷨")�������ϢժҪ,����ʹ��SHA-1��160λ�㷨
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			System.out.println("\n" + messageDigest.getProvider().getInfo());
			// ��ʼʹ���㷨
			messageDigest.update(plainText);
			System.out.println("\nDigest:");
			// ����㷨������
			System.out.println(byte2hex(messageDigest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

}
