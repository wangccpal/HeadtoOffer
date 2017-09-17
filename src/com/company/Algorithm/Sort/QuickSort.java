package com.company.Algorithm.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import static com.company.Algorithm.Sort.Example.exch;

/**
 * Created by CC on 2017/3/1.
 * 快速排序，最差效果是每次找到的主元素都是最大/最小的，平均O(NlgN)，最坏O(N^2)
 */
public class QuickSort {
    public static void sort(int[] nums){//最后一个元素做主元
        quickSort(nums,0,nums.length-1);
    }
    public static void sortFirst(int[] nums){//第一个元素做主元
        sortFirst(nums,0,nums.length-1);
    }
    public static void sortRandom(int[] nums){//加入随机优化
        sortRandom(nums,0,nums.length-1);
    }
    public static void sortRandom(int[] nums,int lo, int hi){//红色算法版，头节点作为主元
        if(hi<=lo) return;
        int m = randomPartition(nums,lo,hi);
        sortFirst(nums,lo,m-1);
        sortFirst(nums,m+1,hi);
    }
    public static void sortFirst(int[] nums,int lo, int hi){//红色算法版，头节点作为主元
        if(hi<=lo) return;
        int m = partitionFirst(nums,lo,hi);
        sortFirst(nums,lo,m-1);
        sortFirst(nums,m+1,hi);
    }
    public static int [] quickSort (int [] nums, int lo, int hi){

        if(lo < hi) {              //if first < last
            int p = partition(nums, lo, hi);    //part array into 2 parts，这个就是额外的空间复杂度
            quickSort(nums, 0, p - 1);
            quickSort(nums, p + 1, hi);
            return nums;
        }
        return nums;
    }
    public static int partitionFirst(int[]nums,int lo,int hi){
        int v= nums[lo];
        int i = lo;
        int j = hi+1;
        while(true) {
            while (nums[++i] < v) if (i == hi) break;//找到一个比v大的数的下标
            while (nums[--j] > v) ;//找到一个比v小的数的下标
//            while (nums[++i] < v) ;
//            while (nums[--j] > v) ;
            if(i>=j) break;//循环终止条件，不能在while条件里写，否则会多一次exch
            exch(nums, i, j);//交换这俩数
        }
        exch(nums,lo,j);
        return j;
    }

    static int partition(int[] nums ,int lo, int hi){
        int pivot = nums[hi];
        int i = lo-1;   //i标志左边区域的终点
        for(int j = lo; j < hi; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums,i, j);//j为指针迭代，小于pivot的放j左边，大于pivot的位置不动
            }
        }
        swap(nums, hi, i+1); //最后把pivot放到中间
        return i+1;
    }
    static int  randomPartition(int[] nums,int lo ,int hi){//随机一个位置与末尾交换
        Random random = new Random();
        int r = random.nextInt(nums.length);
        swap(nums,r, nums.length-1 );
        return partition(nums,lo,hi);
    }
    static void swap(int[] nums, int i, int j){//交换数组的i和i位置
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        sortFirst(nums);
        System.out.println(Arrays.toString(nums));
//        new QuickSort().random(nums);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(new QuickSort().quickSort(nums,0,5)[i]);
//
//        }
//        System.out.println(new Random().nextInt(nums.length));
    }
}
