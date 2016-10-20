package 数字签名;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午3:35:51 
* @Description:  
*/
public class _test {
	public static void main(String[] args) {
	    //初始化KeyGenerator  
	    KeyGenerator keyGenerator;
		try {
			keyGenerator = KeyGenerator.getInstance("HmacMD5");
			//生成密钥  
		    SecretKey secretKey = keyGenerator.generateKey();  
		    System.out.println(new String( secretKey.getEncoded(),"gbk"));   
		} catch (Exception e) {
			e.printStackTrace();
		}  
	    
	}

}

