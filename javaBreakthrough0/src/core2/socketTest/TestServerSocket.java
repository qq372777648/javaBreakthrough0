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
		System.out.println("服务端已经启动~~~");
		//1、建立 ServerSocket对象
		ServerSocket ss=new ServerSocket(9999);
		System.out.println("---1-----");
//		while(true){
			//2、等待接收客户端传来的Socket
			Socket so=ss.accept();//阻塞
			System.out.println("-----2-----");
			//System.out.println(so.getInetAddress());
			//3、通过so包成字符输入流，将客户端传来的数据读入到服务端
			BufferedReader br=new BufferedReader(new InputStreamReader(so.getInputStream()));
			String line=br.readLine();//阻塞
			System.out.println("-----3-----"+line);
			
			//4、将so包成字符输出流，响应给客户端
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(so.getOutputStream()));
			pw.println("<html><body>hello<hr/></body></html>");
			pw.flush();
			System.out.println("-----4-----");
			
			
			//5、关闭大对象
			pw.close();
			br.close();
			so.close();
			ss.close();
//		}
	}
}
