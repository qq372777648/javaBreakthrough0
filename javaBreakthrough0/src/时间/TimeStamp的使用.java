package 时间;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/** 
* @author lzw 
* @version 创建时间：2016年8月1日 上午10:36:52 
* @Description:  
*/
public class TimeStamp的使用 {
	public static void main(String[] args) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 sdf = new SimpleDateFormat("yyyy-MM-dd");

		  Timestamp nowdate = new Timestamp(System.currentTimeMillis());

		  String datestr = sdf.format(nowdate);

		  System.out.println(datestr);
	}

}

