package ģ������ǩ��;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��1�� ����5:44:11 
* @Description:  
*/
public class ���ȴ���Կ�� {
	
	public static void main(String[] args) {
		createPairKey();
	}
	public static void createPairKey() {
		try {
			// �����ض����㷨һ����Կ��������
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
			
			//!!!!ע1��2���㣨3000/576������ֵ��������һ��Կ�ף�ֵһ������ͬһ��Կ�ף���ô3000��576���������룬й¶����������֤�����
			// ��������������� (RNG)
			SecureRandom random = new SecureRandom();
			// 1���������ô�������������
			random.setSeed(3000);
			// 2��ʹ�ø��������Դ����Ĭ�ϵĲ������ϣ���ʼ��ȷ����Կ��С����Կ��������
			keygen.initialize(576, random);// keygen.initialize(512);
			
			
			
			// ������Կ��
			KeyPair keys = keygen.generateKeyPair();
			// �õ�����
			PublicKey pubkey = keys.getPublic();
			// �õ�˽��
			PrivateKey prikey = keys.getPrivate();
			// ��˽��д�뵽�ļ�����
			ObjfileUtil.doObjToFile("prikey.bat", new Object[] { prikey});
			// ������д�뵽�ļ�����
			ObjfileUtil.doObjToFile("pubkey.bat", new Object[] { pubkey });
			System.out.println("Կ�׶����ɳɹ���");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	

}

