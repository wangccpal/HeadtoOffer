package util;

import java.util.Arrays;

public class Swap {
	public static void swap(int[]nums,int n1,int n2){
		int temp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = temp;
	}
	public static String swap(String str,int n1,int n2){
		char[] cn= str.toCharArray();
		char temp = cn[n1];
		cn[n1]=cn[n2];
		cn[n2]=temp;
		return cn.toString();

	}
	public static void swap(char[] str,int n1,int n2){
		char temp = str[n1];
		str[n1]=str[n2];
		str[n2]=temp;

	}
	public static void swap1(int[]nums,int n1,int n2){
		n1 = n1^n2;
		n2 = n1^n2;
		n1 = n1^n2;
	}
	public static void main(String[] args) {
		int[] nums = {1,2};
		swap(nums,0,1);
		System.out.println(Arrays.toString(nums));
		swap1(nums,0,1);
		System.out.println(Arrays.toString(nums));
	}
}
