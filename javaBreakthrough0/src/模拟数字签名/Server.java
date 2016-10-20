package ģ������ǩ��;

import java.security.PublicKey;
import java.security.Signature;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��1�� ����5:27:14 
* @Description:  
*/

//��Կ
public class Server {
	public static void main(String[] args) {
		System.out.println(validateSign("clientSignAndMsg.bat"));
	}
	
	
	public static boolean validateSign(String signfile) {
		// ��ȡ����
		PublicKey mypubkey = (PublicKey) ObjfileUtil.getObjFromFile("pubkey.bat", 1);
		// ��ȡǩ��
		byte[] signed = (byte[]) ObjfileUtil.getObjFromFile(signfile, 1);
		// ��ȡ��Ϣ
		String info = (String) ObjfileUtil.getObjFromFile(signfile, 2);
		System.out.println(info);
		try {
			// ��ʼһ��Signature����,���ù�Կ��ǩ��������֤
			Signature signetcheck = Signature.getInstance("DSA");
			// ��ʼ����֤ǩ���Ĺ�Կ
			signetcheck.initVerify(mypubkey);
			// ʹ��ָ���� byte �������Ҫǩ������֤������
			signetcheck.update(info.getBytes());
			// ��֤�����ǩ��
			return signetcheck.verify(signed);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

