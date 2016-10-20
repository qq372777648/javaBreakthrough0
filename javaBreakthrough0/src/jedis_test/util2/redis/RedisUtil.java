package redis;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

import org.codehaus.jettison.json.JSONArray;



public class RedisUtil {
 
  public static String ObjecttoJsonString(Object object){
	  Class<?> classType = object.getClass();
	  Field[] fields = classType.getDeclaredFields();
	  Method[] methods = classType.getDeclaredMethods();
	  HashMap<String,String> map = new HashMap<String,String>();
	  for(Field field:fields){
		  String methodName = parGetName(field.getName());
		  String fieldType = field.getType().getSimpleName();
		  if(methodName!=null && methodName!="" && checkGetMet(methods,methodName)){
			Method fieldGetMet = null;
			try {
				fieldGetMet = classType.getMethod(methodName, new Class[]{});
				Object fieldVal = fieldGetMet.invoke(object,new Object[]{});
				String result="";
				if("Date".equals(fieldType)){
					result = fmtDate((Date)fieldVal);
				}else{
					if(null != fieldVal){
						result = String.valueOf(fieldVal);
					}
				}
				map.put(field.getName(), result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continue;
			}
		  }
	  }
	
	 JSONArray jsonArray =JSONArray.fromObject(map);
	 return jsonArray.toString();
  }
  
  /*public static Object JsonStringtoObject(String JsonStr,Class type){
	  
  }*/
  
  private static String parGetName(String fieldName){
	  if(fieldName==null || fieldName.length()==0) return "";
	  return "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
  }
  
  private static String parSetName(String fieldName){
	  if(fieldName==null || fieldName.length()==0) return "";
	  return "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
  }
  
  private static boolean checkGetMet(Method[] methods,String fieldGetMet){
	  for(Method met:methods){
		  if(fieldGetMet.equals(met.getName())){
			  return true;
		  }
	  }
	  return false;
  }
  
  /** 
   * 格式化string为Date 
   *  
   * @param datestr 
   * @return date 
   */  
  public static java.util.Date parseDate(String datestr) {  
      if (null == datestr || "".equals(datestr)) {  
          return null;  
      }  
      try {  
          String fmtstr = null;  
          if (datestr.indexOf(':') > 0) {  
              fmtstr = "yyyy-MM-dd HH:mm:ss";  
          } else {  
              fmtstr = "yyyy-MM-dd";  
          }  
          SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);  
          return sdf.parse(datestr);  
      } catch (Exception e) {  
          return null;  
      }  
  }  

  /** 
   * 日期转化为String 
   *  
   * @param date 
   * @return date string 
   */  
  public static String fmtDate(Date date) {  
      if (null == date) {  
          return null;  
      }  
      try {  
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",  
                  Locale.US);  
          return sdf.format(date);  
      } catch (Exception e) {  
          return null;  
      }  
  }  

}
