package ����ǩ��;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��5��31�� ����11:33:17
 * @Description:
 */
public class _2˽Կ���� {
	public static void main(String[] args) throws Exception {
		byte[] plainText = "�������".getBytes("UTF8");

		// ͨ��KeyGenerator�γ�һ��key
		System.out.println("\nStart generate AES key");
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		Key key = keyGen.generateKey();
		System.out.println("Finish generating DES key");

		// ���һ��˽?������Cipher��ECB�Ǽ��ܷ�ʽ��PKCS5Padding����䷽��
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		System.out.println("\n" + cipher.getProvider().getInfo());

		// ʹ��˽?����
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
