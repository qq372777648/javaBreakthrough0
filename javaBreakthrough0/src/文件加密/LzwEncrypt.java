package 文件加密;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/** 
* @author lzw 
* @version 创建时间：2016年5月30日 下午2:12:13 
* @Description:  
*/
public class LzwEncrypt {
	public static String EnOrDecrypt(String context,String key){
		try {
			
			//加密
			byte bs[]=context.getBytes("gbk");
			int size=bs.length;
			if(bs.length%4==1)
				context+="###";
			else if(bs.length%4==2)
				context+="##";
			else if(bs.length%4==3)
				context+="#";
			bs=context.getBytes();
			byte kb[]=key.getBytes();
			System.out.println("text　size："+bs.length+","+kb.length);//System.out.println(kb.length);
			for (int i = 0; i < bs.length; i+=kb.length) {
				for(int j=0;j<kb.length;j++)
					bs[i+j]^=kb[j];
			}
			
			return new String(bs);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	public static byte [] EnOrDecrypt(byte [] bs,String key){
			byte kb[]=key.getBytes();
			System.out.println("text　size："+bs.length+","+kb.length);//System.out.println(kb.length);
			for (int i = 0; i < bs.length; i+=kb.length) {
				for(int j=0;j<kb.length;j++){
					if(i+j>=bs.length) 
						break;
					bs[i+j]^=kb[j];
				}
			}
			return bs;
	}
	
	
	//byte 文件
	public static boolean encryOrDecryFile(String filePath,String savePath,String key,boolean isEncry,boolean onlyShow){
		try {
			System.out.println("从文件读出数据");
			FileInputStream fis=new FileInputStream(filePath);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			String line=null;
			
			StringBuffer sbRead=new StringBuffer();
			while ((line = br.readLine()) != null) {
				sbRead.append(line);
				if(isEncry)
					sbRead.append("\r\n");
			}
			
			br.close();
			
			String text=null;
			if(isEncry){//加密
				byte []b1=LzwEncrypt.EnOrDecrypt(sbRead.toString().getBytes(), key);
				StringBuffer sb=new StringBuffer();
				for(byte b:b1){
					sb.append(b+"@@%");
				}
				text=sb.toString();
			}else{//解密
				String []bytesStr=sbRead.toString().split("@@%");
				byte b2[]=new byte[bytesStr.length];
				for (int i = 0; i < bytesStr.length; i++) {
					b2[i]=Byte.parseByte(bytesStr[i]);
				}
				b2=LzwEncrypt.EnOrDecrypt(b2, key);
				text=new String(b2);
			}
			if(!onlyShow){
				PrintWriter pw;
				pw = new PrintWriter(savePath);
				pw.print(text);
				pw.flush();
				pw.close();
			}else{
				System.out.println(text);
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	


}

