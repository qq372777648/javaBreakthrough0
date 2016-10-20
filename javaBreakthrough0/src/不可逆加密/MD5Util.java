package 不可逆加密;

import java.security.MessageDigest;

/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午3:43:45 
* @Description:  
*/
public class MD5Util {
	    /*** 
	     * MD5加密 生成32位md5码
	     * @param 待加密字符串
	     * @return 返回32位md5码
	     */
	    public static String md5Encode(String inStr) throws Exception {
	        MessageDigest md5 = null;
	        try {
	            md5 = MessageDigest.getInstance("MD5");
	        } catch (Exception e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	            return "";
	        }

	        byte[] byteArray = inStr.getBytes("UTF-8");
	        byte[] md5Bytes = md5.digest(byteArray);
	        StringBuffer hexValue = new StringBuffer();
	        for (int i = 0; i < md5Bytes.length; i++) {
	            int val = ((int) md5Bytes[i]) & 0xff;
	            if (val < 16) {
	                hexValue.append("0");
	            }
	            hexValue.append(Integer.toHexString(val));
	        }
	        return hexValue.toString();
	    }

	    /**
	     * 测试主函数
	     * @param args
	     * @throws Exception
	     */
	    public static void main(String args[]) throws Exception {
	        String str = new String("");
	        String key="123";
	        
	        System.out.println("MD5后：" + md5Encode(str+key));
	        System.out.println("MD5后：" + md5Encode(str+key));
	        System.out.println(md5Encode(""));//e10adc3949ba59abbe56e057f20f883e
	        
	        //cadc7690-d73a-32e5-bead-a83b89208e0a
	    }

}

