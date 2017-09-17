package com.company.LeetCode;

/**
 * Created by CC on 2017/3/17.
 */
public class L153 {
    public int findMin(int[] nums) {

        for(int i = 0;i < nums.length - 1; i++){
            if(nums[i+1] > nums [i] ) return nums[i+1];
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
