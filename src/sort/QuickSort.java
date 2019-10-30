package sort;

import java.util.Arrays;

import util.Swap;;
public class QuickSort {
	static void quickSort(int[] nums){
		sort(nums,0,nums.length-1);
	}
	private static void sort(int[] nums, int i, int j) {
		if(i>=j) return;
		int k = partition(nums,i,j);
		sort(nums,i,k-1);
		sort(nums,k+1,j);
	}
	private static int partition(int[] nums, int start, int end) {
		int p = nums[start];
		
		int i = start;
		int j = end+1;
			while(true) {
				while(nums[++i]<=p) if(i==end) break;
				while(nums[--j]>=p) if(j==start) break;
				if(i>=j)break;
				Swap.swap(nums,i,j);
			}
			Swap.swap(nums,j,start);
		return j;
	}
	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};
		new QuickSort();
		QuickSort.quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
}
