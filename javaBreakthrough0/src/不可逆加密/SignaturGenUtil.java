package ���������;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import ����ǩ��.Base64Util;


// ժҪ+˽Կ     ��˽Կй¶�����ã�
/**
 * @ClassName:SignaturGenUtil
 * @Description:ǩ���㷨
 * @author Mark
 * @date 2012-1-5 ����11:27:25
 */
public class SignaturGenUtil {

	/**
	 * @Title: generator
	 * @Description: ����ǩ���㷨
	 * @param @param pStringToSign
	 * @param @param pKey
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String generator(String pStringToSign, String pKey) {
		//pStringToSign =getAbstract(pStringToSign);
		String lSignature = "None";
		try {
			Mac lMac = Mac.getInstance("HmacSHA1");
			SecretKeySpec lSecret = new SecretKeySpec(pKey.getBytes(), "HmacSHA1");
			lMac.init(lSecret);

			byte[] lDigest = lMac.doFinal(pStringToSign.getBytes());
			lSignature = new String(Base64Util.encode(lDigest));
		} catch (NoSuchAlgorithmException lEx) {
			throw new RuntimeException("Problems calculating HMAC", lEx);
		} catch (InvalidKeyException lEx) {
			throw new RuntimeException("Problems calculating HMAC", lEx);
		}
		return lSignature;
	}
	
	
	//ժҪ
	public static String getAbstract(String message){
		try {
			
			byte[] plainText = message.getBytes("UTF8");
			// ʹ��getInstance("�㷨")�������ϢժҪ,����ʹ��SHA-1��160λ�㷨
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			System.out.println("\n" + messageDigest.getProvider().getInfo());
			// ��ʼʹ���㷨
			messageDigest.update(plainText);
			System.out.println("\nDigest(ժҪ):");
			// ����㷨������
			String astractMsg=byte2hex(messageDigest.digest());
			System.out.println(astractMsg);
			return astractMsg;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	
	public static void main(String[] args) {
		System.out.println(generator("ţ��", "sb"));
		System.out.println(generator("ţ��", "sb"));
		
	}
	
	
	

}
