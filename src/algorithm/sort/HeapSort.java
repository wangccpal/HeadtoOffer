package algorithm.sort;

import java.util.Arrays;

/**
 * Created by CC on 2017/3/31.
 */
public class HeapSort {
    public static void sort(int[] nums) {
        int N = nums.length-1;
        for (int k = N / 2-1; k >= 0; k--)//构造最大堆，k是最后一个数(N）的父亲
            sink(nums, k, N);
        //然后把最后一个元素与堆顶交换，恢复最大堆状态。
        while(N>0){
            Example.exch(nums,0,N--);
            sink(nums,0,N);
        }
    }

    public static void sink(int[] nums, int k, int N) {//最大堆的下沉操作,k是节点的下标，N控制数组的未排序大小
        while (2 * k +1<= N) {//2k+1<N表示有两个孩子，=N表示只有一个孩子啦
            int j = 2 * k+1;
            if (j < N && nums[j] < nums[j + 1]) j++;//找到k的子节点较大的那一个,注意！！这里判断j<N表明j不是最后一个节点
            if (nums[k] >= nums[j]) break; //如果父节点大于子节点就不用交换了
            Example.exch(nums, k, j);
            k = j;
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,3,4,2,2,5,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
