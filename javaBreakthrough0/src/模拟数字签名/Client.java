package 模拟数字签名;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午5:27:22 
* @Description:  
*/

//私钥
public class Client {
	public static void main(String[] args) {
		signToInfo("来源身份证明！（来源用私钥签名）", "clientSignAndMsg.bat");
	}
	
	

	
	public static void signToInfo(String info, String signfile) {
		PrivateKey myprikey=null;
		//------------模拟非法来源
		try {
			// 根据特定的算法一个密钥对生成器
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
			//!!!!注1、2两点（3000/576）的数值决定是哪一对钥匙，值一样就是同一对钥匙，那么3000和576就像是密码，泄露了照样不能证明身份
			// 加密随机数生成器 (RNG)
			SecureRandom random = new SecureRandom();
			// 1重新设置此随机对象的种子
			random.setSeed(3000);
			// 2使用给定的随机源（和默认的参数集合）初始化确定密钥大小的密钥对生成器
			keygen.initialize(512, random);// keygen.initialize(512);
			// 生成密钥组
			KeyPair keys = keygen.generateKeyPair();
			// 得到私匙
			myprikey = keys.getPrivate();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//-------------------
		
		// 从文件当中读取私匙
		//myprikey = (PrivateKey) ObjfileUtil.getObjFromFile("prikey.bat", 1);
		
		try {
			// Signature 对象可用来生成和验证数字签名
			Signature signet = Signature.getInstance("DSA");
			// 初始化签署签名的私钥
			signet.initSign(myprikey);
			// 更新要由字节签名或验证的数据
			signet.update(info.getBytes());
			// 签署或验证所有更新字节的签名，返回签名
			byte[] signed = signet.sign();

			//--------------模拟数据被篡改
			//info="123";
			//-------------------------
			
			// 将数字签名,信息放入文件中
			ObjfileUtil.doObjToFile(signfile, new Object[] { signed, info });
			System.out.println("客户签名成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

