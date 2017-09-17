package com.company.LeetCode;

/**
 * Created by CC on 2017/3/15.
 */
public class L74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int start = 0;
        int end = matrix.length - 1;
        int midCol = 0;
        while (start <= end) {
            midCol = start + (end - start) / 2;
            int val = matrix[midCol][0];
            if (val == target) return true;
            else if (val > target) {
                end = midCol - 1;
                // if (end == 0) midCol = 0;break;
            } else {
                start = midCol + 1;
                // if (start == matrix.length-1) midCol = matrix.length-1;
            }
        }
        midCol = end;
        start = 0;
        end = matrix[0].length - 1;
        int midRow = 0;
        while (start <= end && midCol >= 0) {
            midRow = start + (end - start) / 2;
            int val = matrix[midCol][midRow];
            if (val == target) return true;
            else if (val > target) end = midRow - 1;
            else start = midRow + 1;
        }
        return false;
    }

    public static void main(String[] args) {
       int [][]x= {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(x,3));
    }
}
