package 不可逆加密;

import java.security.MessageDigest;

/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午3:45:57 
* @Description:  
*/
public class SHAUtil {
    /*** 
     * SHA加密 生成40位SHA码
     * @param 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
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
    	String str = new String("http://blog.csdn.net/hfmbook/article/details/7605527");
	    String key="123";
	    long time=System.currentTimeMillis();
	    System.out.println(time);
        System.out.println("SHA后：" + shaEncode("1"+time+key));
        System.out.println("SHA后：" + shaEncode("1"+time+key));
    }
}

