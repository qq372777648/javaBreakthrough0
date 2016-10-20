package ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**   
* @author lzw   
* @date 2016年9月18日 下午1:14:33 
* @Description: 
* @version V1.0   
*/
public class 下载 {
	
	
	  public static void main(String[] args) throws Exception {
	    FTPClient ftpClient = new FTPClient();
	    String hostName = "120.25.220.137";
	    String userName = "lzw";
	    String password = "123456";
	    String remoteDir = "11";
	    try {
	      ftpClient.connect(hostName, 21);
	      ftpClient.setControlEncoding("UTF-8");
	      ftpClient.login(userName, password);
	      System.out.println("-");
	      ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
	      System.out.println("-2");
	      FTPFile[] files = ftpClient.listFiles(remoteDir);
	      System.out.println("-3");
	      for (int i = 0; i < files.length; i++) {
	        System.out.println(files[i].getName());
	      }
	      File file = new File("d://index.jsp");
	      FileOutputStream fos = new FileOutputStream(file);
	      ftpClient.retrieveFile(remoteDir + "/index.jsp", fos);
	      System.out.println("-9");
	      fos.close();
	    } catch (SocketException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	
	

}
