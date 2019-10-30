package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wangchenge
 * @date 2019-09-29
 * 最长公共子序列
 * 序列s1，s2，长度分别为m,n, 设C(i,j)为s1[0 ... i-1], s2[0 ... j-1]的最长公共子序列的长度，则C(m,n)即为所求；
 * if(s1[i] == s2[j]) C(i,j) = C(i-1, j-1) + 1; else C(i,j) = Max(C(i-1,j),C(i,j-1));
 **/
public class LCS {
    public static void main(String[] args) {
        final LCS lcs = new LCS();
        final String s = lcs.lcsRes("intention", "execution");
        System.out.println(s);
    }

    /**
     * 只输出长度
     *
     * @param s1
     * @param s2
     * @return
     */
    int lcs(String s1, String s2) {
        final char[] cs1 = s1.toCharArray();
        final char[] cs2 = s2.toCharArray();
        int m = cs1.length, n = cs2.length;
        //避免初始化问题
        int[][] res = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (cs1[i] == cs2[j]) res[i + 1][j + 1] = res[i][j] + 1;
                else res[i + 1][j + 1] = Math.max(res[i][j + 1], res[i + 1][j]);
            }
        return res[m][n];
    }


    /**
     * 输出一个最长的，并且优化一下空间复杂度
     *
     * @param s1
     * @param s2
     * @return
     */
    String lcsRes(String s1, String s2) {
        final char[] cs1 = s1.toCharArray();
        final char[] cs2 = s2.toCharArray();
        int m = cs1.length, n = cs2.length;
        //避免初始化问题, 1代表斜线，2代表横线，3代表竖线
        int[][] loc = new int[m + 1][n + 1];
        int[] res = new int[n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cs1[i] == cs2[j]) {
                    res[j + 1] = res[j] + 1;
                    loc[i + 1][j + 1] = 1;
                } else {
                    res[j + 1] = Math.max(res[j + 1], res[j]);
                    if (res[j + 1] == res[j]) loc[i + 1][j + 1] = 2;
                    else loc[i + 1][j + 1] = 3;
                }
            }
        }
        Deque<Character> queue = new ArrayDeque<>();
        int i = m, j = n;
        while (loc[i][j] != 0) {
            if (loc[i][j] == 1) {
                queue.push(cs1[i-1]);
                i = i - 1;
                j = j - 1;
            } else if (loc[i][j] == 2) {
                j--;
            } else {
                i--;
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) stringBuilder.append(queue.pop());
        return stringBuilder.toString();
    }
}
