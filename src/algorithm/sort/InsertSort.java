package algorithm.sort;

import java.util.Arrays;

import static algorithm.sort.Example.exch;

/**插入排序：对接近有序的数组排序速度很快
 * 时间复杂度O(N2),最好O（N）
 * 稳定
 * Created by CC on 2017/3/30.
 */
public class InsertSort {
    public static void sort(int[] nums){
        int N = nums.length;
        for(int i = 1;i<N;i++){//注意起始条件是i=1，这样j才能和j-1比较
//            for(int j = i;j>0&&nums[j]<nums[j-1];j--){
//                exch(nums,j,j-1);
//            }
            for(int j = i;j>0&&nums[j]<nums[j-1];j--){//从后面开始比较，如果比前一个大就不用比了，所以不能把判断加到里面！！
                exch(nums,j,j-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
