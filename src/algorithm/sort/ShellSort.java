package algorithm.sort;

import java.util.Arrays;

/**希尔排序
 * 通过一次次排序为h有序的数组来实现，时间复杂度和递增数列有关，本次是O（N^3/2）
 * 不稳定
 * Created by CC on 2017/3/30.
 */
public class ShellSort {
    public static void sort(int[] nums){
        int N = nums.length;
        int h = 1;
        while(h<N/3) h = h*3+1;
        while(h>=1){
            //将数组变为h有序
            for(int i = h;i<N;i++){
                for(int j = i;j>=h&&nums[j]<nums[j-h];j-=h) Example.exch(nums,j,j-h);
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
