package leetcode;


/**
 * 564. Find the Closest Palindrome
 *
 * @author Wangchenge
 * @date 2018-09-14
 **/
public class NearestPalindromic {
    public String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return Integer.parseInt(n) - 1 + "";
        }
        long ln = Long.valueOf(n);
        int nn = n.length();
        //对n=10，应对比9和11，对于n=99，应对比99和101；
        StringBuilder stringBuilder = new StringBuilder(nn);
        while(nn-- > 1){
            stringBuilder.append(9);
        }
        long ex1 = Long.valueOf(stringBuilder.toString());
        long ex2 = Long.valueOf(stringBuilder.toString()) + 2;
        long ex0 = findNear(ex1,ex2,ln);
        stringBuilder.append(9);
        long ex11 = Long.valueOf(stringBuilder.toString());
        long ex22 = Long.valueOf(stringBuilder.toString()) + 2;
        long ex00 = findNear(ex11,ex22,ln);
        long ex = findNear(ex00,ex0,ln);

        //对于其他的情况，例如12345，需要对比12321，11311，13311三种，为了避免13045，找到13031，还需要对比12992，13131，同理13088
        String result ;
        String c = "";
        boolean isOdd = n.length() % 2 == 1;
        String main = isOdd ? n.substring(0,n.length()/2 + 1) : n.substring(0,n.length()/2);
        StringBuilder sb = new StringBuilder(main);
        if (isOdd) sb.deleteCharAt(sb.length() - 1);
        String r1 = main + sb.reverse().toString();

        int intMain = Integer.parseInt(main);
        int int2 = intMain + 1;
        int int3 = intMain - 1;

        sb = new StringBuilder(int2 + "");
        if (isOdd) sb.deleteCharAt(sb.length() - 1);
        String r2 = int2 + sb.reverse().toString();

        sb = new StringBuilder(int3 + "");
        if (isOdd) sb.deleteCharAt(sb.length() - 1);
        String r3 = int3 + sb.reverse().toString();

        long l1 = Long.valueOf(r1);
        long l2 = Long.valueOf(r2);
        long l3 = Long.valueOf(r3);

        long temp = findNear(l2,l3,ln);
        long rtemp = findNear(ex,temp,ln);
        result = findNear(rtemp,l1,ln) + "";

        return result;
    }

    long findNear(long l1, long l2, long ln) {
        if (l1==ln) return l2;
        if (l2==ln) return l1;
        if (Math.abs(l1 - ln) == Math.abs(l2 - ln)) return l1 > l2? l2 : l1;
        else if (Math.abs(l1 - ln) < Math.abs(l2 - ln)) {
            return l1;
        }
        else {
            return l2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NearestPalindromic().nearestPalindromic("10801"));

    }
}
