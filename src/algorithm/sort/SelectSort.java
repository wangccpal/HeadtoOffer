package algorithm.sort;

import java.util.Arrays;

/**选择排序
 * 三个时间复杂度O(N2) ,空间复杂度O(N)
 * 特点是交换次数固定是N次交换
 * Created by CC on 2017/3/30.
 */
public class SelectSort {
    public static void sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int min=i;
            for(int j=i;j<nums.length;j++){//找到最小元素的下标
                if(nums[j] < nums[min]) min=j;
            }
            exch(nums,i,min);
        }
    }
    public static void exch(int[] nums,int i,int j){
        int tmp = nums[i];
        nums [i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
