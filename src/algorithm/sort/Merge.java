package algorithm.sort;

import java.util.Arrays;

public class Merge {
	public static int[] mergeSort(int[]nums){
		int auk[] = new int[nums.length];
		sort(nums,0,nums.length-1,auk);
		return nums;
	}
	private static void sort(int[] nums, int left, int right,int[] auk) {
		if(left>=right) return;
		int mid = left+(right-left)/2;
		sort(nums,left,mid,auk);
		sort(nums,mid+1,right,auk);
		merge(nums,left,mid,right,auk);
	}
	private static void merge(int[] nums, int left, int mid, int right,int[] auk) {
		for(int i=left;i<=right;i++){
			auk[i] = nums[i];
		}
		int i=left,j=mid+1;
		for(int k=left;k<=right;k++){
		if(i>mid) nums[k] = auk[j++];
		else if (j>right) nums[k]=auk[i++];
		else nums[k] = auk[i] < auk[j] ? auk[i++]:auk[j++]; 
		}
		
	}
	public static void main(String[] args) {
        int[] nums = {2, 4, 1, 2, 5};
        System.out.println(Arrays.toString(mergeSort(nums)));
	}

}
