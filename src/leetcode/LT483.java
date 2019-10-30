package leetcode;

import java.math.BigInteger;

/**
 * @author Wangchenge
 * @date 2019-07-03
 * good Base n
 **/
public class LT483 {
    public static void main(String[] args) {
        final String s = new LT483().goodBase("2251799813685247");
        System.out.println(s);
    }

    String goodBase(String n) {
        BigInteger bn = new BigInteger(n);
        long num = Long.parseLong(n);
        final int max_m = (int) (Math.log(num) / Math.log(2));
        for (int m = max_m; m > 1; m--) {
            BigInteger k = BigInteger.valueOf((long) Math.floor(Math.pow(num, 1.0 / m)));
            final BigInteger left = bn.multiply(k.subtract(BigInteger.ONE));
            final BigInteger right = k.pow(m + 1).subtract(BigInteger.ONE);
            if (left.equals(right)) {
                return k.toString();
            }
        }
        return bn.subtract(BigInteger.ONE).toString();
    }
}
