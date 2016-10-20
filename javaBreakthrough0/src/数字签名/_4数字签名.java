package ����ǩ��;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

/**
 * @author lzw
 * @version ����ʱ�䣺2016��5��31�� ����12:34:52
 * @Description:
 */
public class _4����ǩ�� {
	public static void main(String[] args) {
		try {
			byte[] plainText = "�������".getBytes("UTF8");
			// �γ�RSA��Կ��
			System.out.println("\nStart generating RSA key");
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(1024);

			KeyPair key = keyGen.generateKeyPair();
			System.out.println("Finish generating RSA key");
			// ʹ��˽?ǩ��
			Signature sig = Signature.getInstance("SHA1WithRSA");
			sig.initSign(key.getPrivate());
			sig.update(plainText);
			byte[] signature = sig.sign();
			System.out.println(sig.getProvider().getInfo());
			System.out.println("\nSignature:");
			System.out.println(new String(signature, "UTF8"));

			// ʹ�ù�?��֤
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
