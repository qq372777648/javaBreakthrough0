package ʱ��;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��8��1�� ����10:36:52 
* @Description:  
*/
public class TimeStamp��ʹ�� {
	public static void main(String[] args) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 sdf = new SimpleDateFormat("yyyy-MM-dd");

		  Timestamp nowdate = new Timestamp(System.currentTimeMillis());

		  String datestr = sdf.format(nowdate);

		  System.out.println(datestr);
	}

}

