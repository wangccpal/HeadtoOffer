package leetcode;

/**
 * FindMedianSortedArrays
 *
 * @author Wangchenge
 * @date 2019-07-16
 **/
public class LT4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
            int t1 = m;
            m = n;
            n = t1;
        }
        int max = nums1.length;
        int min = 0;
        int half = (m + n + 1)/2;
        while(min <= max) {
            int i = (max + min)/2;
            int j = half - i;
            if(i > min && nums1[i-1] > nums2[j]) max = i - 1;
            else if(i < max && nums1[i] < nums2[j-1]) min = i + 1;
            else {
                int left;
                int right;
                if(i==0) {
                    left = nums2[j-1];
                } else if(j == 0) {
                    left = nums1[i-1];
                } else {
                    left = Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m + n) % 2 == 1) return left;

                if(i==m) {
                    right = nums2[j];
                } else if(j==n){
                    right = nums1[i];
                } else {
                    right = Math.min(nums1[i],nums2[j]);
                }

                return (left + right) /2;
            }
        }
        return 0d;
    }

    public static void main(String[] args) {
        final int[] ints = {1, 2};
        final int[] ints1 = {3, 4};
        new LT4().findMedianSortedArrays(ints, ints1);
    }
}
