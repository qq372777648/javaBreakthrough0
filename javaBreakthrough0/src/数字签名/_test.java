package ����ǩ��;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��1�� ����3:35:51 
* @Description:  
*/
public class _test {
	public static void main(String[] args) {
	    //��ʼ��KeyGenerator  
	    KeyGenerator keyGenerator;
		try {
			keyGenerator = KeyGenerator.getInstance("HmacMD5");
			//������Կ  
		    SecretKey secretKey = keyGenerator.generateKey();  
		    System.out.println(new String( secretKey.getEncoded(),"gbk"));   
		} catch (Exception e) {
			e.printStackTrace();
		}  
	    
	}

}

