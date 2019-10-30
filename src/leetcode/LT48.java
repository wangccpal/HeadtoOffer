package leetcode;

import util.PrintUtil;

/**
 * rotate images
 *
 * @author Wangchenge
 * @date 2019-03-05
 **/
public class LT48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp1, tmp2;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) {
                tmp1 = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                tmp2 = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = tmp1;
                tmp1 = matrix[n-1-j][i];
                matrix[n-1-j][i] = tmp2;
                matrix[i][j] = tmp1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(PrintUtil.printMatrix(input));
        new LT48().rotate(input);
        System.out.println(PrintUtil.printMatrix(input));
    }
}
