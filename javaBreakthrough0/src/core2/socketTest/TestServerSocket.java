package core2.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerSocket {
	
	public static void main(String[] args) throws IOException {
		System.out.println("������Ѿ�����~~~");
		//1������ ServerSocket����
		ServerSocket ss=new ServerSocket(9999);
		System.out.println("---1-----");
//		while(true){
			//2���ȴ����տͻ��˴�����Socket
			Socket so=ss.accept();//����
			System.out.println("-----2-----");
			//System.out.println(so.getInetAddress());
			//3��ͨ��so�����ַ������������ͻ��˴��������ݶ��뵽�����
			BufferedReader br=new BufferedReader(new InputStreamReader(so.getInputStream()));
			String line=br.readLine();//����
			System.out.println("-----3-----"+line);
			
			//4����so�����ַ����������Ӧ���ͻ���
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(so.getOutputStream()));
			pw.println("<html><body>hello<hr/></body></html>");
			pw.flush();
			System.out.println("-----4-----");
			
			
			//5���رմ����
			pw.close();
			br.close();
			so.close();
			ss.close();
//		}
	}
}
