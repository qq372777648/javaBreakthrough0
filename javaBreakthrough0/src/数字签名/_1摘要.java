package 数字签名;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lzw
 * @version 创建时间：2016年5月31日 上午11:26:16
 * @Description:
 */
public class _1摘要 {
	public static void main(String[] args)  {
		try {
			
			byte[] plainText = "123".getBytes("UTF8");
			// 使用getInstance("算法")来获得消息摘要,这里使用SHA-1的160位算法
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			System.out.println("\n" + messageDigest.getProvider().getInfo());
			// 开始使用算法
			messageDigest.update(plainText);
			System.out.println("\nDigest:");
			// 输出算法运算结果
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
