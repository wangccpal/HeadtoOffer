package Head67;

public class NumberOf1 {
	//可用flag左移，n&n-1来做
	public static int NumberOf1(int n) {
		
		int count = 0;//方法1
		if (n >= 0)
			while (n != 0) {
				count+=n & 1;
				n = n >> 1;
			}
		if (n < 0) {//方法2
            int flag = 1;
			while (flag!=0) {
				if((n & flag)==flag) count++; //注意flag与出来就不是1 啦
				flag =flag<<1;
			}
//			count++; //加上符号位1
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =-1;
		System.out.println(NumberOf1(n));
		System.out.println(Integer.bitCount(n));
		System.out.println(Power(2,-3));
		System.out.println(-5%3);
	}
    public static double Power(double base, int exponent) {
        if(exponent==0) return 1;
        double res = 1;
        int exp = Math.abs(exponent);
        
        while(exp-->0){
            res*=base;
        }
        
        return exponent>0 ? res:1/res;
  }
}
