package 数字签名;

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
* @version 创建时间：2016年5月31日 上午11:46:45 
* @Description:  公钥加密也叫不对称加密，不对称算法使用一对密钥对，一个公钥，一个私钥，
* 使用公钥加密的数据，只有私钥能解开（可用于加密）；
* 同时，使用私钥加密的数据，只有公钥能解开（签名）。
*/
public class _3公钥加密 {
	public static void main(String[] args) {
		 try {
			byte[] plainText="你好世界".getBytes("UTF8");
			 //构成一个RSA密钥
			 System.out.println("\nStart generating RSA key");
			 KeyPairGenerator keyGen=KeyPairGenerator.getInstance("RSA");
			 keyGen.initialize(1024);
			 KeyPair key=keyGen.generateKeyPair();
			 System.out.println("Finish generating RSA key");

			 //获得一个RSA的Cipher类，使用公?加密
			 Cipher cipher=Cipher.getInstance("RSA/ECB/PKCS1Padding");
			 System.out.println("\n"+cipher.getProvider().getInfo());

			 System.out.println("\nStart encryption");
			 cipher.init(Cipher.ENCRYPT_MODE,key.getPublic());
			 byte[] cipherText=cipher.doFinal(plainText);
			 System.out.println("Finish encryption:");
			 System.out.println(new String(cipherText,"UTF8"));

			 //使用私?解密
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

