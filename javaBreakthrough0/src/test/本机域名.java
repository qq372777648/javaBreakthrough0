package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class 本机域名 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostName()); // 输出本机名
		
		InetAddress address2 = InetAddress.getByName("www.oracle.com");
		System.out.println(address2.getHostName()); // 无需访问DNS服务器，直接返回域名
		
		System.out.println(InetAddress.getLocalHost());
		
		InetAddress[] array = InetAddress.getAllByName("www.oracle.com");
		for(int i=0; i<array.length; i++){
			System.out.println("ip "+ i +" "+ InetAddress.getAllByName("www.oracle.com")[0]);
		}
		
		InetAddress address3 = InetAddress.getByName("104.82.220.89");
		System.out.println(address3.getHostName()); // 需要访问DNS服务器才能得到域名
//		InetAddress address4 = InetAddress.getByName("1.2.3.4"); // IP地址不存在
//		System.out.println(address4.getHostName()); // 直接返回IP地址
	}

}
