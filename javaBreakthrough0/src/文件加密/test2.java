package �ļ�����;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2 {
	public static void main(String[] args) {
		
		//��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
        
		
        
       
		try {
			
//			FileWriter writer = new FileWriter("d://aaaa.txt", true);
//	        writer.write("fffsd");
//	        writer.close();
	        
	        File f=new File("d://aaaa.txt");
			
			if(!f.exists())
				f.createNewFile();
			
//				FileOutputStream fos= new FileOutputStream(f);			
//				for (int i = 0; i < list.size(); i++) {
//					fos.write(list.get(i));
//				}
//				fos.close();
//				
//				FileInputStream fis=new FileInputStream(f);
//				for (int i = 0; i < list.size(); i++) {
//					System.out.println(fis.read());//һ���ֽ�
//				}
			
//			FileOutputStream fos= new FileOutputStream(f);
//			OutputStreamWriter osw=new OutputStreamWriter(fos);
			
			
//			PrintWriter pw=new PrintWriter(f);
//			StringBuilder strb=new StringBuilder();
//			for (int i = 0; i < list.size(); i++) {
//				strb.append(list.get(i)+"\t");
//			}
//			pw.print("sfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdfsfgsdf");
//			pw.flush();
//			pw.close();
			
			
			
			
			System.out.println("���ļ�������������");
			FileInputStream fis=new FileInputStream(f);
			InputStreamReader isr=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			
			String line=null;
			while ((line = br.readLine()) != null) {
				//���ı���ӡ������̨
				System.out.println(line);
				}
			br.close();

			
			
			
			
				
			
//			FileOutputStream fos= new FileOutputStream(f);		
			
			
			
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
