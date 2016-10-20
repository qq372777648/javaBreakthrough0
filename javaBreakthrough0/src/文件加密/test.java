package 文件加密;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/** 
* @author lzw 
* @version 创建时间：2016年5月30日 下午2:12:29 
* @Description:  
*/
public class test {
	public static void main(String[] args) {
//		String text=" 才fsd  s;ldf中 是对方考虑  放到空间 飞ef LD";
//		System.out.println("源码----------");
//		for(byte b:text.getBytes())
//			System.out.println(b);
//		
//		System.out.println(new String(LzwEncrypt.EnOrDecrypt(LzwEncrypt.EnOrDecrypt(text.getBytes(), "逗猫"),"逗猫")));
		
		
		//Scanner scan=new Scanner(System.in);
		
		//加密文件
		//LzwEncrypt.encryOrDecryFile( "D://DOC//Desktop//Constant//code(不改)//201605code//丿.txt", "D://DOC//Desktop//Constant//code(不改)//201605code//加密文件.txt",scan.next(),true,false);
		
		//解密文件
		//LzwEncrypt.encryOrDecryFile( "D://DOC//Desktop//Constant//code(不改)//201605code//加密文件.txt", "D://DOC//Desktop//Constant//code(不改)//201605code//解密内容.txt",scan.next(),false,true);
		
		String s="a"+"\r\n"+"c";
		System.out.println(s);
		
		
		
		
		
		
		
		
		
		
		
		
//		byte []b1=LzwEncrypt.EnOrDecrypt(text.getBytes(), "逗猫");
//		StringBuffer sb=new StringBuffer();
//		for(byte b:b1){
//			sb.append(b+",");
//		}
//		PrintWriter pw;
//		try {
//			pw = new PrintWriter("d://aaaa.txt");
//			pw.print(sb.toString());
//			pw.flush();
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		
//		System.out.println("加密----------");
//		String s=LzwEncrypt.EnOrDecrypt(text, "逗猫");
//		for(byte b:s.getBytes())
//			System.out.println(b);
//		System.out.println(s);
//		
//		System.out.println("解密----------");
//		String ss=LzwEncrypt.EnOrDecrypt(s, "逗猫");
//		for(byte b:ss.getBytes())
//			System.out.println(b);
//		System.out.println(ss);
//		
//		System.out.println("----------");
//		String ss=" 数";
//		byte b[]=ss.getBytes();
//		System.out.println(new String(b));
	}

}

