package test;
/** 
* @author lzw 
* @version ����ʱ�䣺2016��6��1�� ����4:45:09 
* @Description:  
*/
public class String��intern {
    public static void main(String[] args) throws Exception {  
        String a =  "b" ;   
        String b =  "b" ;   
          
        System.out.print( a == b);   
          
        String c = "d" ;  
        String d = new String( "d" ).intern() ;   
        System.out.println( c == d);  
    }   

}

