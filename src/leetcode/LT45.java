package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LT45 {
    public int jump(int[] nums) {
        int res = 0, end = 0;
        while(end < nums.length) {
            int max = 0;
            int start = end;
            for(int i = 1; i <= nums[start]; i++) {
                if(i + start >= nums.length-1) return res+1;
                if(nums[i+start] >= max) {
                    end = start + i;
                    max = nums[start+i];
                }
            }
            res++;
        }
        return res;

    }

    public static void main(String[] args) {
        int jump = new LT45().jump(new int[]{
                2, 1, 1, 1, 1
        });
        System.out.println(jump);
    }
}
