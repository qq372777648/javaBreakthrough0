package ģ������ǩ��;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��1�� ����5:27:22 
* @Description:  
*/

//˽Կ
public class Client {
	public static void main(String[] args) {
		signToInfo("��Դ���֤��������Դ��˽Կǩ����", "clientSignAndMsg.bat");
	}
	
	

	
	public static void signToInfo(String info, String signfile) {
		PrivateKey myprikey=null;
		//------------ģ��Ƿ���Դ
		try {
			// �����ض����㷨һ����Կ��������
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
			//!!!!ע1��2���㣨3000/576������ֵ��������һ��Կ�ף�ֵһ������ͬһ��Կ�ף���ô3000��576���������룬й¶����������֤�����
			// ��������������� (RNG)
			SecureRandom random = new SecureRandom();
			// 1�������ô�������������
			random.setSeed(3000);
			// 2ʹ�ø��������Դ����Ĭ�ϵĲ������ϣ���ʼ��ȷ����Կ��С����Կ��������
			keygen.initialize(512, random);// keygen.initialize(512);
			// ������Կ��
			KeyPair keys = keygen.generateKeyPair();
			// �õ�˽��
			myprikey = keys.getPrivate();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}//-------------------
		
		// ���ļ����ж�ȡ˽��
		//myprikey = (PrivateKey) ObjfileUtil.getObjFromFile("prikey.bat", 1);
		
		try {
			// Signature ������������ɺ���֤����ǩ��
			Signature signet = Signature.getInstance("DSA");
			// ��ʼ��ǩ��ǩ����˽Կ
			signet.initSign(myprikey);
			// ����Ҫ���ֽ�ǩ������֤������
			signet.update(info.getBytes());
			// ǩ�����֤���и����ֽڵ�ǩ��������ǩ��
			byte[] signed = signet.sign();

			//--------------ģ�����ݱ��۸�
			//info="123";
			//-------------------------
			
			// ������ǩ��,��Ϣ�����ļ���
			ObjfileUtil.doObjToFile(signfile, new Object[] { signed, info });
			System.out.println("�ͻ�ǩ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

