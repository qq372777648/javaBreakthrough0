package core2.socketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	ServerSocket ss;
	{
		try {
			ss=new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public TestServer(){
		System.out.println("服务端启动了~~~");
		try {
			int i=0;
			while(true){
				Socket so=ss.accept();
				System.out.println("第"+(++i)+"个客户端连接上了");
				new MyThread(so).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class MyThread extends Thread{
		Socket so;
		BufferedReader br;
		public MyThread(Socket so) {
			try {
				this.so=so;
				this.br=new BufferedReader(new InputStreamReader(so.getInputStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void run(){
			try {
				while(true){
//					String str=br.readLine();
//					if("bye".equals(str)) {
//						System.out.println("一个客户端已经退出");
//						break;
//					}
//					System.out.println("服务端："+str);
					System.out.println("推送");
					PrintWriter pw=new PrintWriter(new OutputStreamWriter(so.getOutputStream()));
					pw.println("<html><body>hello<hr/></body></html>");
					pw.flush();
					try {
						sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					br.close();
					so.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new TestServer();
	}
}
