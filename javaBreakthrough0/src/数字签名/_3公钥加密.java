package ����ǩ��;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��5��31�� ����11:46:45 
* @Description:  ��Կ����Ҳ�в��ԳƼ��ܣ����Գ��㷨ʹ��һ����Կ�ԣ�һ����Կ��һ��˽Կ��
* ʹ�ù�Կ���ܵ����ݣ�ֻ��˽Կ�ܽ⿪�������ڼ��ܣ���
* ͬʱ��ʹ��˽Կ���ܵ����ݣ�ֻ�й�Կ�ܽ⿪��ǩ������
*/
public class _3��Կ���� {
	public static void main(String[] args) {
		 try {
			byte[] plainText="�������".getBytes("UTF8");
			 //����һ��RSA��Կ
			 System.out.println("\nStart generating RSA key");
			 KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
			 keyGen.initialize(1024);
			 KeyPair key=keyGen.generateKeyPair();
			 System.out.println("Finish generating RSA key");

			 //���һ��RSA��Cipher�࣬ʹ�ù�?����
			 Cipher cipher=Cipher.getInstance("RSA/ECB/PKCS1Padding");
			 System.out.println("\n"+cipher.getProvider().getInfo());

			 System.out.println("\nStart encryption");
			 cipher.init(Cipher.ENCRYPT_MODE,key.getPublic());
			 byte[] cipherText=cipher.doFinal(plainText);
			 System.out.println("Finish encryption:");
			 System.out.println(new String(cipherText,"UTF8"));

			 //ʹ��˽?����
			 System.out.println("\nStart decryption");
			 cipher.init(Cipher.DECRYPT_MODE,key.getPrivate());
			 byte[] newPlainText=cipher.doFinal(cipherText);
			 System.out.println("Finish decryption:");
			 System.out.println(new String(newPlainText,"UTF8"));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

