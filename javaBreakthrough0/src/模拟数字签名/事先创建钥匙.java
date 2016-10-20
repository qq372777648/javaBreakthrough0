package 模拟数字签名;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午5:44:11 
* @Description:  
*/
public class 事先创建钥匙 {
	
	public static void main(String[] args) {
		createPairKey();
	}
	public static void createPairKey() {
		try {
			// 根据特定的算法一个密钥对生成器
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
			
			//!!!!注1、2两点（3000/576）的数值决定是哪一对钥匙，值一样就是同一对钥匙，那么3000和576就像是密码，泄露了照样不能证明身份
			// 加密随机数生成器 (RNG)
			SecureRandom random = new SecureRandom();
			// 1、重新设置此随机对象的种子
			random.setSeed(3000);
			// 2、使用给定的随机源（和默认的参数集合）初始化确定密钥大小的密钥对生成器
			keygen.initialize(576, random);// keygen.initialize(512);
			
			
			
			// 生成密钥组
			KeyPair keys = keygen.generateKeyPair();
			// 得到公匙
			PublicKey pubkey = keys.getPublic();
			// 得到私匙
			PrivateKey prikey = keys.getPrivate();
			// 将私匙写入到文件当中
			ObjfileUtil.doObjToFile("prikey.bat", new Object[] { prikey});
			// 将公匙写入到文件当中
			ObjfileUtil.doObjToFile("pubkey.bat", new Object[] { pubkey });
			System.out.println("钥匙对生成成功！");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	

}

