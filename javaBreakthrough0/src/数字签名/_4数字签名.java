package 数字签名;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

/**
 * @author lzw
 * @version 创建时间：2016年5月31日 下午12:34:52
 * @Description:
 */
public class _4数字签名 {
	public static void main(String[] args) {
		try {
			byte[] plainText = "你好世界".getBytes("UTF8");
			// 形成RSA公钥对
			System.out.println("\nStart generating RSA key");
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(1024);

			KeyPair key = keyGen.generateKeyPair();
			System.out.println("Finish generating RSA key");
			// 使用私?签名
			Signature sig = Signature.getInstance("SHA1WithRSA");
			sig.initSign(key.getPrivate());
			sig.update(plainText);
			byte[] signature = sig.sign();
			System.out.println(sig.getProvider().getInfo());
			System.out.println("\nSignature:");
			System.out.println(new String(signature, "UTF8"));

			// 使用公?验证
			System.out.println("\nStart signature verification");
			sig.initVerify(key.getPublic());
			sig.update(plainText);
			try {
				if (sig.verify(signature)) {
					System.out.println("Signature verified");
				} else
					System.out.println("Signature failed");
			} catch (SignatureException e) {
				System.out.println("Signature failed");
			}
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
