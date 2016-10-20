package 模拟数字签名;

import java.security.PublicKey;
import java.security.Signature;

/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午5:27:14 
* @Description:  
*/

//公钥
public class Server {
	public static void main(String[] args) {
		System.out.println(validateSign("clientSignAndMsg.bat"));
	}
	
	
	public static boolean validateSign(String signfile) {
		// 读取公匙
		PublicKey mypubkey = (PublicKey) ObjfileUtil.getObjFromFile("pubkey.bat", 1);
		// 读取签名
		byte[] signed = (byte[]) ObjfileUtil.getObjFromFile(signfile, 1);
		// 读取信息
		String info = (String) ObjfileUtil.getObjFromFile(signfile, 2);
		System.out.println(info);
		try {
			// 初始一个Signature对象,并用公钥和签名进行验证
			Signature signetcheck = Signature.getInstance("DSA");
			// 初始化验证签名的公钥
			signetcheck.initVerify(mypubkey);
			// 使用指定的 byte 数组更新要签名或验证的数据
			signetcheck.update(info.getBytes());
			// 验证传入的签名
			return signetcheck.verify(signed);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

