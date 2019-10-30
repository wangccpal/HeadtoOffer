package leetcode;

import util.PrintUtil;

/**
 * 174. Dungeon Game
 *
 * @author Wangchenge
 * @date 2019-01-05
 **/
public class LeetCode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] res = new int[m][n];
        res[0][0] = 1 - dungeon[m-1][n-1];
        if(res[0][0] <= 0) res[0][0] = 1;

        for(int i=1;i<n;i++) {
            res[0][i] = res[0][i-1] - dungeon[m-1][n-i-1];
            if(res[0][i] <= 0 ) res[0][i]=1;
        }
        for(int i=1;i<m;i++) {
            res[i][0] = res[i-1][0] - dungeon[m-i-1][n-1];
            if(res[i][0] <= 0) res[i][0] = 1;
        }
        for (int i = 1;i < m;i++) {
            for (int j = 1;j < n;j++) {
                int temp1 = res[i - 1][j] - dungeon[m-i-1][n-j-1];
                int temp2 = res[i][j - 1] - dungeon[m-i-1][n-j-1];
                if(temp1 <= 0 || temp2 <= 0) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = Math.min(temp1,temp2);
                }
                System.out.println(PrintUtil.printMatrix(res));
            }
        }
        return res[m-1][n-1];
    }

    public static void main(String[] args)  {
        int[][] input = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new LeetCode174().calculateMinimumHP(input));
    }
}
