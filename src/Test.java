import java.util.Arrays;

public class Test {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int i = 5;
//		int j = 10;
//		System.out.println(~j);
//		System.out.println(i + ~j);
//	}
	    public static void main(String args[]) {  
	    	int[] s = {1,2,3};
	    	System.out.println(Arrays.toString(s));
	        method1(9);  
	          
	    }  
	  
	    /** 
	     * 打印出九九乘法表 
	     * @param i 
	     */  	
	    public static void method1(int i) {  
	        if (i == 1) {  
	            System.out.println("1*1=1"); //当i=1后执行这句，可是执行完这句后为什么却是执行for循环  
	        } else {  
	            method1(i - 1); //总是循环直至i=1，这里明白  
	            for (int j = 1; j <= i; j++) { //执行完i==1后为什么会执行这里，if条件满足后不是不执行else了吗，而且i的值怎么会是2，并且会一直增加直至到9，i不是等于一吗，我晕了，请详解，谢谢  
	                System.out.print(j + "*" + i + "=" + j * i +" ");  
	            }  
	            System.out.println();  
	        }  
	    }   
}
