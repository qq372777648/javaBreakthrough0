package ��������;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��7��1�� ����11:12:00 
* @Description:  
*/
public class UrlEncode {
	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode("����", "UTF-8"));
			System.out.println(URLDecoder.decode("%E9%80%97%E9%80%BC","UTF-8"));
			
//			���ġ���>�����Ĭ��utf-8 -> tomcatĬ��ISO-8859-1-> new String(name.getBytes("ISO-8859-1"),"UTF-8")�õ�ԭʼ����
			
			
			//url���� ����������Ҳ���б���   �磺%��%25    +��%2B   
			System.out.println(URLEncoder.encode("��% #+", "UTF-8"));
			System.out.println(URLEncoder.encode(URLEncoder.encode("��", "UTF-8")));
			System.out.println(URLEncoder.encode(URLEncoder.encode(URLEncoder.encode("��", "UTF-8"))));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

