package 类型转换;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/** 
* @author lzw 
* @version 创建时间：2016年7月21日 下午5:01:22 
* @Description:  
*/
public class 保留两位小数 {
	public static void main(String[] args) {
		Object o="1";
		
		System.out.println(
				Float.parseFloat((String)o)+0.0
		);
		
		BigDecimal bd = new BigDecimal(o.toString());
		bd.setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println(bd.toString());
		
		
		BigDecimal bg = new BigDecimal(o.toString());
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
        
        System.out.println(moneyType(o));
        
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(100.2465324));
	}
	
	static String moneyType(Object o){
		String numStr=o.toString();
		int leng=numStr.length();
		int pointIndex=numStr.indexOf('.');
		
		if(pointIndex==-1)//100
			numStr+=".00";
		else if(pointIndex==leng-2)//100.0
			numStr+="0";
		return numStr;
	}


}

