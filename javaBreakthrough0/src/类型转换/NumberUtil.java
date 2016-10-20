package 类型转换;
/** 
* @author lzw 
* @version 创建时间：2016年7月21日 下午5:04:14 
* @Description:  
*/
public class NumberUtil {
	public static void main(String[] args) {
		double x1 = 0.026;
		double get_double = (double)(Math.round(x1*100)/100.0);
		System.out.println(get_double);
		
		long a=11;
		long b=6;
		
		System.out.println(format2Bit(123.544));
		System.out.println(format2Bit(123.545));
		System.out.println((double)b/a);
		System.out.println(format2Bit((double)b/a));
		System.out.println(format4Bit((double)b/a));
		
		
	}
	
	public static double format2Bit(double d){
		return (Math.round(d*100)/100.0);
	}
	public static double format4Bit(double d){
		return (Math.round(d*10000)/10000.0);
	}

}


//1、只要输出结果的时候可以用以下方法：
//double x1 = 0.026;
//System.out.println(String.format("%.2f", x1));
//结果：0.03
//2、使用数据转换（4种方法）
////方案一:
//get_double = (double)(Math.round(result_value*100)/100.0)
////方案二:
//DecimalFormat df = new DecimalFormat("#.##");
//get_double = Double.ParseDouble(df.format(result_value));
////方案三:
//get_double = Double.ParseDouble(String.format("%.2f",result_value));
////方案四:
//BigDecimal bd = new BigDecimalresult_value();
//BigDecimal bd2 = bd.setScale(2,BigDecimal .ROUND_HALF_UP);
//get_double = Double.ParseDouble(bd2.ToString());