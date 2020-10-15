package leetcode;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 全排列
 */
public class LT46 {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0);
        return res;
    }

    void helper(int[] nums, int start) {
        if(start == nums.length-1) {

            return;
        }
        for(int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper(nums, start+1);
            swap(nums, start, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        new LT46().permute(new int[]{1, 2, 3});
    }
}
