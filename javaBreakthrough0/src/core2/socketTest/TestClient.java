package core2.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ����Ѿ�����");
		Socket so=new Socket("192.168.1.52",8888);
		
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(so.getOutputStream()));
		pw.println("TestClient�е��ַ���");
		pw.flush();
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(so.getInputStream()));
		String line=br.readLine();//����
		System.out.println("=====�ͻ��˶����ķ����������===="+line);
		
		br.close();
		pw.close();
		so.close();
	}
	
}
