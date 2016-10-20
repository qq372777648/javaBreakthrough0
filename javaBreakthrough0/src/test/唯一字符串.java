package test;

import java.util.Random;

public class 唯一字符串 {
	
	//10000 可以
//	、、5000不行
	public static Integer getNum(int maxNum) { 
		int length=(maxNum+"").length();
	    Random random = new Random();
	    
	    String str;
	    do {
	    	Integer temp=random.nextInt(maxNum);
	    	 if(temp>0){
	    		 str=temp+"";
	    		 int randomLength=str.length();
		    	 if(randomLength<length){
		    		 for(int j=0;j<length-randomLength;j++)
		    			 str=str+"0";
		    	 }
		    	 break;
	    	 }
		} while (true);
		return Integer.parseInt(str);
	     
	} 
	
	//可以
	public static Integer getNum2(int maxNum) { 
	    Random random = new Random();
	    Integer temp;
	    //int baseNum=getBaseNum(maxNum);
	    double baseNum=Math.pow(10,(maxNum+"").length()-1);
	    do {
			 temp=random.nextInt(maxNum);
			 if(temp>baseNum){
				 break;
			 }
		} while (true);
		return temp;
	     
	} 
	//可以
		public static int getNum3(int maxNum) { 
		    Random random = new Random();
		    int temp;
		    int baseNum=(int)Math.pow(10,(maxNum+"").length()-1);
			temp=random.nextInt(maxNum-baseNum);
			temp+=baseNum;
			return temp;
		     
		} 
	
	public static int getBaseNum(int num){
		int length=(num+"").length();
		int baseNum=1;
//		Math.pow(double m, double n) 求m的n次方的
		for (int i = 0; i < length-1; i++) {
			baseNum=baseNum*10;
		}
		return baseNum;
	}
	public static String genId2(int digit)
    {
    	Random random = new Random();
        char[] digits ={'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int temp;
        String id = "";
        
        for (int i = 0; i < digit; )
        {
            temp = random.nextInt(10);
            if(temp>0){
            	id += String.valueOf(digits[temp]);
            	i++;
            }
        }
        return id;
    } 
	
	public static void main(String[] args) {
//		System.out.println(getNum());
		//System.out.println(System.currentTimeMillis()); 
		for (int i = 0; i < 10; i++) {
			//System.out.println(genId2(4));
			System.out.println(getNum3(103));
		}
		
		//System.out.println(getBaseNum(5453453));
	}

}
