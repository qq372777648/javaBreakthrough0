package 不可逆加密;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import 数字签名.Base64Util;


// 摘要+私钥     （私钥泄露会无用）
/**
 * @ClassName:SignaturGenUtil
 * @Description:签名算法
 * @author Mark
 * @date 2012-1-5 上午11:27:25
 */
public class SignaturGenUtil {

	/**
	 * @Title: generator
	 * @Description: 生成签名算法
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
	
	
	//摘要
	public static String getAbstract(String message){
		try {
			
			byte[] plainText = message.getBytes("UTF8");
			// 使用getInstance("算法")来获得消息摘要,这里使用SHA-1的160位算法
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			System.out.println("\n" + messageDigest.getProvider().getInfo());
			// 开始使用算法
			messageDigest.update(plainText);
			System.out.println("\nDigest(摘要):");
			// 输出算法运算结果
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
		System.out.println(generator("牛逼", "sb"));
		System.out.println(generator("牛逼", "sb"));
		
	}
	
	
	

}
