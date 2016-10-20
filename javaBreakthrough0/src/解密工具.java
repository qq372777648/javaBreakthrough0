import java.util.Scanner;

import 文件加密.LzwEncrypt;

/** 
* @author lzw 
* @version 创建时间：2016年5月30日 下午5:04:28 
* @Description:  
*/
public class 解密工具 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//加密文件
		//LzwEncrypt.encryOrDecryFile( "D://DOC//Desktop//Constant//code(不改)//201605code//丿.txt", "D://DOC//Desktop//Constant//code(不改)//201605code//加密文件.txt",scan.next(),true,false);
		//解密文件
		LzwEncrypt.encryOrDecryFile( "D://DOC//Desktop//Constant//code(不改)//201605code//加密文件.txt", "D://DOC//Desktop//Constant//code(不改)//201605code//解密内容.txt",scan.next(),false,true);
				
				
	}

}

