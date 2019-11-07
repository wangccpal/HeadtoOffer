package leetcode;

/**
 * minCut
 *
 * @author Wangchenge
 * @date 2019-11-07
 * @see L131PalindromePart
 **/
public class LT132 {
    public static void main(String[] args) {
        System.out.println(new LT132().minCut("eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj"));
    }

    public int minCut(String s) {
        return process(s, 0, s.length());
    }

    private int process(String s, int start, int end) {
        int min = Integer.MAX_VALUE;
        if (isPalindrome(s.substring(start, end))) {
            return 0;
        } else {
            for (int i = 1; i < end - start; i++) {
                int cut = 0;
                cut = 1 + process(s, start, start + i) + process(s, start + i, end);
                if (cut < min) min = cut;
            }
        }
        return min;
    }

    private boolean isPalindrome(String substring) {
        int i = 0, j = substring.length() - 1;
        while (i < j) {
            if (substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
