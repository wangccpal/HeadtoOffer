package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Wangchenge
 * @date 2019-07-29
 **/
public class LT239 {
    Deque<Integer> deque = new ArrayDeque();
    public int[] maxSlidingWindow(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            push(deque,nums,i,k);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[deque.getFirst()];
        for (int i = k; i < nums.length; i++) {
            push(deque,nums,i,k);
            res[i-k+1] = nums[deque.getFirst()];
        }
        return res;
    }

    void push(Deque<Integer> deque, int[] nums, int i, int k){
        if (!deque.isEmpty() && i - deque.getFirst() == k) deque.removeFirst();
        while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) deque.removeLast();
        deque.addLast(i);
    }

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        System.out.println(Arrays.toString(new LT239().maxSlidingWindow(nums, 2)));
    }
}
