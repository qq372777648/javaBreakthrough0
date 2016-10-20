package 可逆加密;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午4:37:13 
* @Description:  
*/
public class Simple3DES {
	
	public static void main(String[] args) {
		Simple3DES test = new Simple3DES();
		
		String oldString = "your home or my home";
		String SPKEY = "lzw";
		
		System.out.println("1。SPKEY为:  " + SPKEY);
		System.out.println("2。内容为:  " + oldString);
		String reValue = test.get3DESEncrypt(oldString, SPKEY);
		System.out.println("进行3-DES加密后的内容: " + reValue);
		String reValue2 = test.get3DESDecrypt(reValue, SPKEY);
		System.out.println("进行3-DES解密后的内容: " + reValue2);
	}
	
	public String get3DESEncrypt(String src, String spkey) {
		String requestValue = "";
		try {

			// 得到3-DES的密钥匙
			byte[] enKey = getEnKey(spkey);
			// 要进行3-DES加密的内容在进行/"UTF-16LE/"取字节
			byte[] src2 = src.getBytes("UTF-16LE");
			// 进行3-DES加密后的内容的字节
			byte[] encryptedData = Encrypt(src2, enKey);

			// 进行3-DES加密后的内容进行BASE64编码   (BASE64编码: 8bit字节代码最常用的编码方式)
			String base64String = getBase64Encode(encryptedData);
			// BASE64编码去除换行符后
			String base64Encrypt = filter(base64String);

			// 对BASE64编码中的HTML控制码进行转义的过程
			requestValue = getURLEncode(base64Encrypt);
			// System.out.println(requestValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return requestValue;
	}

	
	
	private byte[] getEnKey(String spKey) {
		byte[] desKey = null;
		try {
			byte[] desKey1 = md5(spKey);
			desKey = new byte[24];
			int i = 0;
			while (i < desKey1.length && i < 24) {
				desKey[i] = desKey1[i];
				i++;
			}
			if (i < 24) {
				desKey[i] = 0;
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return desKey;
	}

	private byte[] md5(String strSrc) {
		byte[] returnByte = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			returnByte = md5.digest(strSrc.getBytes("GBK"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnByte;
	}

	public byte[] Encrypt(byte[] src, byte[] enKey) {
		byte[] encryptedData = null;
		try {
			DESedeKeySpec dks = new DESedeKeySpec(enKey);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			SecretKey key = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encryptedData = cipher.doFinal(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedData;
	}

	public String getBase64Encode(byte[] src) {
		String requestValue = "";
		try {
			BASE64Encoder base64en = new BASE64Encoder();
			requestValue = base64en.encode(src);
			// System.out.println(requestValue);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return requestValue;
	}

	private String filter(String str) {
		String output = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			int asc = str.charAt(i);
			if (asc != 10 && asc != 13)
				sb.append(str.subSequence(i, i + 1));
		}
		output = new String(sb);
		return output;
	}

	public String getURLEncode(String src) {
		String requestValue = "";
		try {

			requestValue = URLEncoder.encode(src);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return requestValue;
	}

	
	
	public String get3DESDecrypt(String src, String spkey) {
		String requestValue = "";
		try {
			//
			String URLValue = getURLDecoderdecode(src);
			//BASE64解码
			BASE64Decoder base64Decode = new BASE64Decoder();
			byte[] base64DValue = base64Decode.decodeBuffer(URLValue);

			// 要进行3-DES加密的内容在进行/"UTF-16LE/"取字节
			requestValue = deCrypt(base64DValue, spkey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requestValue;
	}
	
	public String getURLDecoderdecode(String src) {
		String requestValue = "";
		try {

			requestValue = URLDecoder.decode(src);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return requestValue;
	}
	
	public String deCrypt(byte[] debase64, String spKey) {
		String strDe = null;
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("DESede");
			byte[] key = getEnKey(spKey);
			DESedeKeySpec dks = new DESedeKeySpec(key);
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
			SecretKey sKey = keyFactory.generateSecret(dks);
			cipher.init(Cipher.DECRYPT_MODE, sKey);
			byte ciphertext[] = cipher.doFinal(debase64);
			strDe = new String(ciphertext, "UTF-16LE");
		} catch (Exception ex) {
			strDe = "";
			ex.printStackTrace();
		}
		return strDe;
	}
}

