package ʱ��;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/** 
* @author lzw 
* @version ����ʱ�䣺2016��7��12�� ����6:13:47 
* @Description:  
*/
public class ʱ������������� {
	 public static void main(String[] args) throws Exception
	 {
	  Calendar cal = Calendar.getInstance();
	  String start = "2012-02-01";
	  String end = "2012-05-02";
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  Date dBegin = sdf.parse(start);
	  Date dEnd = sdf.parse(end);
	  List<Date> lDate = findDates(dBegin, dEnd);
	  for (Date date : lDate)
	  {
	   System.out.println(sdf.format(date));
	  }
	 }
	 public static List<Date> findDates(Date dBegin, Date dEnd)
	 {
	  List lDate = new ArrayList();
	  lDate.add(dBegin);
	  Calendar calBegin = Calendar.getInstance();
	  // ʹ�ø����� Date ���ô� Calendar ��ʱ��
	  calBegin.setTime(dBegin);
	  Calendar calEnd = Calendar.getInstance();
	  // ʹ�ø����� Date ���ô� Calendar ��ʱ��
	  calEnd.setTime(dEnd);
	  // ���Դ������Ƿ���ָ������֮��
	  while (dEnd.after(calBegin.getTime()))
	  {
	   // ���������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
	   calBegin.add(Calendar.DAY_OF_MONTH, 1);
	   lDate.add(calBegin.getTime());
	  }
	  return lDate;
	 }

}

