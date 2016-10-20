package test;
/** 
* @author lzw 
* @version 创建时间：2016年6月1日 下午4:45:09 
* @Description:  
*/
public class String的intern {
    public static void main(String[] args) throws Exception {  
        String a =  "b" ;   
        String b =  "b" ;   
          
        System.out.print( a == b);   
          
        String c = "d" ;  
        String d = new String( "d" ).intern() ;   
        System.out.println( c == d);  
    }   

}

