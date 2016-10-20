package 数字签名;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @author lzw
 * @version 创建时间：2016年5月31日 上午11:33:17
 * @Description:
 */
public class _2私钥加密 {
	public static void main(String[] args) throws Exception {
		byte[] plainText = "你好世界".getBytes("UTF8");

		// 通过KeyGenerator形成一个key
		System.out.println("\nStart generate AES key");
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		Key key = keyGen.generateKey();
		System.out.println("Finish generating DES key");

		// 获得一个私?加密类Cipher，ECB是加密方式，PKCS5Padding是填充方法
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		System.out.println("\n" + cipher.getProvider().getInfo());

		// 使用私?加密
		System.out.println("\nStart encryption:");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherText = cipher.doFinal(plainText);
		System.out.println("Finish encryption:");
		System.out.println(new String(cipherText, "UTF8"));

		System.out.println("\nStart decryption:");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] newPlainText = cipher.doFinal(cipherText);
		System.out.println("Finish decryption:");
		System.out.println(new String(newPlainText, "UTF8"));

	}

}
