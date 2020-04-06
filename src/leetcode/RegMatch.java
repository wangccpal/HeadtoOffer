package leetcode;

import static util.PrintUtil.printMatrix;

public class RegMatch {
    public boolean isMatch(String s, String p) {
        //dp问题，首先定义dp[i][j]为s的前i个字符与p的前i个字符是否匹配，这样当si == pj 时， dp[i][j] = dp[i-1][j-1];
        //复杂的是si != pj的时候，(1) 当pj是字母的时候，dp[i][j] = false;(2)pj = . ，dp[i][j] == dp[i-1][j-1]
        //(3)pj = *, (3.1)*代表0次，dp[i][j] = dp[i][j-2], (3.2)*代表多次, 此时有一个前提条件是si==p(j-1), dp[i][j] = dp[i-1][j],完了合并3.1和3.2
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 2; i <= n; i++) {
            dp[0][i] = dp[0][i-2] && p.charAt(i-1) == '*';
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') dp[i][j] = dp[i-1][j-1];
                else if(j > 1 && p.charAt(j-1) == '*') {
                    dp[i][j] |= dp[i][j-2];
                    if (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) dp[i][j] |= dp[i-1][j];
                }
            }
        }
        System.out.println(printMatrix(dp));
        return dp[m][n];
    }

    public static void main(String[] args) {
        new RegMatch().isMatch("a","ab*");
        new RegMatch().isMatch("ad","ab*");
    }
}
