package ���������;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CryptTest {
	public static void main(String[] args) {
		CryptTest jiami = new CryptTest();
		// ִ��MD5����"Hello world!"
		System.out.println("Hello����MD5:" + jiami.encryptToMD5("Hello"));
		
		// ����һ��DES�㷨���ܳ�
		SecretKey key = jiami.createSecretKey("DES");
		// ���ܳ׼�����Ϣ"Hello world!"
		String str1 = jiami.encryptToDES(key, "Hello");
		System.out.println("ʹ��des������ϢHelloΪ:" + str1);
		// ʹ������ܳ׽���
		String str2 = jiami.decryptByDES(key, str1);
		System.out.println("���ܺ�Ϊ��" + str2);
		
		
		// �������׺�˽��  (�����зŵ�mykeys.bat)
		jiami.createPairKey();
		// ��Hello world!ʹ��˽�׽���ǩ��
		jiami.signToInfo("Hello", "mysign.bat");
		// ���ù��׶�ǩ��������֤��
		if (jiami.validateSign("mysign.bat")) {
			System.out.println("Success!");
		} else {
			System.out.println("Fail!");
		}

	}
	
	
	public String encryptToMD5(String info) {
		byte[] digesta = null;
		try {
			// �õ�һ��md5����ϢժҪ
			MessageDigest alga = MessageDigest.getInstance("MD5");
			// ���Ҫ���м���ժҪ����Ϣ
			alga.update(info.getBytes());
			// �õ���ժҪ
			digesta = alga.digest();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// ��ժҪתΪ�ַ���
		String rs = byte2hex(digesta);
		return rs;
	}

	public String encryptToSHA(String info) {
		byte[] digesta = null;
		try {
			// �õ�һ��SHA-1����ϢժҪ
			MessageDigest alga = MessageDigest.getInstance("SHA-1");
			// ���Ҫ���м���ժҪ����Ϣ
			alga.update(info.getBytes());
			// �õ���ժҪ
			digesta = alga.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// ��ժҪתΪ�ַ���
		String rs = byte2hex(digesta);
		return rs;
	}

	// //////////////////////////////////////////////////////////////////////////
	public SecretKey createSecretKey(String algorithm) {
		// ����KeyGenerator����
		KeyGenerator keygen;
		// ���� ��Կ����
		SecretKey deskey = null;
		try {
			// ��������ָ���㷨��������Կ�� KeyGenerator ����
			keygen = KeyGenerator.getInstance(algorithm);
			// ����һ����Կ
			deskey = keygen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// �����ܳ�
		return deskey;
	}

	public String encryptToDES(SecretKey key, String info) {
		// ���� �����㷨,���� DES,DESede,Blowfish
		String Algorithm = "DES";
		// ��������������� (RNG),(���Բ�д)
		SecureRandom sr = new SecureRandom();
		// ����Ҫ���ɵ�����
		byte[] cipherByte = null;
		try {
			// �õ�����/������
			Cipher c1 = Cipher.getInstance(Algorithm);
			// ��ָ������Կ��ģʽ��ʼ��Cipher����
			// ����:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)
			c1.init(Cipher.ENCRYPT_MODE, key, sr);
			// ��Ҫ���ܵ����ݽ��б��봦��,
			cipherByte = c1.doFinal(info.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �������ĵ�ʮ��������ʽ
		return byte2hex(cipherByte);
	}

	public String decryptByDES(SecretKey key, String sInfo) {
		// ���� �����㷨,
		String Algorithm = "DES";
		// ��������������� (RNG)
		SecureRandom sr = new SecureRandom();
		byte[] cipherByte = null;
		try {
			// �õ�����/������
			Cipher c1 = Cipher.getInstance(Algorithm);
			// ��ָ������Կ��ģʽ��ʼ��Cipher����
			c1.init(Cipher.DECRYPT_MODE, key, sr);
			// ��Ҫ���ܵ����ݽ��б��봦��
			cipherByte = c1.doFinal(hex2byte(sInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return byte2hex(cipherByte);
		return new String(cipherByte);
	}

	// /////////////////////////////////////////////////////////////////////////////
	public void createPairKey() {
		try {
			// �����ض����㷨һ����Կ��������
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
			// ��������������� (RNG)
			SecureRandom random = new SecureRandom();
			// �������ô�������������
			random.setSeed(1000);
			// ʹ�ø��������Դ����Ĭ�ϵĲ������ϣ���ʼ��ȷ����Կ��С����Կ��������
			keygen.initialize(512, random);// keygen.initialize(512);
			// ������Կ��
			KeyPair keys = keygen.generateKeyPair();
			// �õ�����
			PublicKey pubkey = keys.getPublic();
			// �õ�˽��
			PrivateKey prikey = keys.getPrivate();
			// ������˽��д�뵽�ļ�����
			doObjToFile("mykeys.bat", new Object[] { prikey, pubkey });
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public void signToInfo(String info, String signfile) {
		// ���ļ����ж�ȡ˽��
		PrivateKey myprikey = (PrivateKey) getObjFromFile("mykeys.bat", 1);
		// ���ļ��ж�ȡ����
		PublicKey mypubkey = (PublicKey) getObjFromFile("mykeys.bat", 2);
		try {
			// Signature ������������ɺ���֤����ǩ��
			Signature signet = Signature.getInstance("DSA");
			// ��ʼ��ǩ��ǩ����˽Կ
			signet.initSign(myprikey);
			// ����Ҫ���ֽ�ǩ������֤������
			signet.update(info.getBytes());
			// ǩ�����֤���и����ֽڵ�ǩ��������ǩ��
			byte[] signed = signet.sign();

			// ������ǩ��,����,��Ϣ�����ļ���
			doObjToFile(signfile, new Object[] { signed, mypubkey, info });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateSign(String signfile) {
		// ��ȡ����
		PublicKey mypubkey = (PublicKey) getObjFromFile(signfile, 2);
		// ��ȡǩ��
		byte[] signed = (byte[]) getObjFromFile(signfile, 1);
		// ��ȡ��Ϣ
		String info = (String) getObjFromFile(signfile, 3);
		try {
			// ��ʼһ��Signature����,���ù�Կ��ǩ��������֤
			Signature signetcheck = Signature.getInstance("DSA");
			// ��ʼ����֤ǩ���Ĺ�Կ
			signetcheck.initVerify(mypubkey);
			// ʹ��ָ���� byte �������Ҫǩ������֤������
			signetcheck.update(info.getBytes());
			// ��֤�����ǩ��
			return signetcheck.verify(signed);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String byte2hex(byte[] b) {
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

	public byte[] hex2byte(String hex) {
		byte[] ret = new byte[8];
		byte[] tmp = hex.getBytes();

		for (int i = 0; i < 8; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}

	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

	public void doObjToFile(String file, Object[] objs) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			for (int i = 0; i < objs.length; i++) {
				oos.writeObject(objs[i]);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Object getObjFromFile(String file, int i) {
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			for (int j = 0; j < i; j++) {
				obj = ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}


}
