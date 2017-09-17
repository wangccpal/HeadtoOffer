package com.company.Algorithm.Sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：O(NlgN),空间复杂度O(N)
 * 稳定的
 * Created by CC on 2017/3/30.
 */
public class MergeSort {
    private static int[] aux;//额外的空间复杂度

    public static int[] mergeSort(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    //自顶向下归并
    private static void sort(int[] nums, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
//        if(lo==mid || mid==hi) return;
        if (hi <= lo) return;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public static void merge(int[] nums, int lo, int mid, int hi) {
        //将数组nums[lo..mid],nums[mid+1,hi]合并
        int i = lo;//左半区起点
        int j = mid + 1;//右半区起点
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) nums[k] = aux[j++];//左半区耗尽
            else if (j > hi) nums[k] = aux[i++];//右半区耗尽
            else nums[k] = aux[i] > aux[j] ? aux[j++] : aux[i++];//前面的《=后面的取前面的
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 5};
        System.out.println(Arrays.toString(mergeSort(nums)));
    }
}
