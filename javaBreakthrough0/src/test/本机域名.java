package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class �������� {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostName()); // ���������
		
		InetAddress address2 = InetAddress.getByName("www.oracle.com");
		System.out.println(address2.getHostName()); // �������DNS��������ֱ�ӷ�������
		
		System.out.println(InetAddress.getLocalHost());
		
		InetAddress[] array = InetAddress.getAllByName("www.oracle.com");
		for(int i=0; i<array.length; i++){
			System.out.println("ip "+ i +" "+ InetAddress.getAllByName("www.oracle.com")[0]);
		}
		
		InetAddress address3 = InetAddress.getByName("104.82.220.89");
		System.out.println(address3.getHostName()); // ��Ҫ����DNS���������ܵõ�����
//		InetAddress address4 = InetAddress.getByName("1.2.3.4"); // IP��ַ������
//		System.out.println(address4.getHostName()); // ֱ�ӷ���IP��ַ
	}

}
