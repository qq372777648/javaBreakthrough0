import java.util.Scanner;

import �ļ�����.LzwEncrypt;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��5��30�� ����5:04:28 
* @Description:  
*/
public class ���ܹ��� {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//�����ļ�
		//LzwEncrypt.encryOrDecryFile( "D://DOC//Desktop//Constant//code(����)//201605code//د.txt", "D://DOC//Desktop//Constant//code(����)//201605code//�����ļ�.txt",scan.next(),true,false);
		//�����ļ�
		LzwEncrypt.encryOrDecryFile( "D://DOC//Desktop//Constant//code(����)//201605code//�����ļ�.txt", "D://DOC//Desktop//Constant//code(����)//201605code//��������.txt",scan.next(),false,true);
				
				
	}

}

