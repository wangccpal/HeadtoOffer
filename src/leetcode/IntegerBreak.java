package leetcode;
//Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
//
//        For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
//
//        Note: You may assume that n is not less than 2 and not larger than 58.
public class IntegerBreak {

    public static int integerBreak(int n) {
        int rst = 1;
        if(n == 2) return 1;
        if(n == 3) return 2;
        while(n - 3 >= 0) {
            rst *= 3;
            n -= 3;
        }
        if (n % 3 == 2) rst = rst * 2;
        else if (n % 3 == 1) rst = rst / 3 * 4;
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10  ));
    }
}
