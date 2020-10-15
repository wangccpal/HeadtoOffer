package leetcode;

import java.util.ArrayList;
import java.util.List;

class CountSmaller {
    int[] temp;
    int[] idx;
    int[] counter;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        temp = new int[nums.length];
        idx = new int[nums.length];
        counter = new int[nums.length];

        for(int i = 0; i < nums.length; i++) idx[i] = i;
        mergeSort(nums, 0, nums.length-1);

        for(int i : counter) list.add(i);
        return list;
    }

    void mergeSort(int[] nums, int l , int r) {
        if(l >= r) return;
        int mid = (l+r)/2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);

        if(nums[idx[mid]] <= nums[idx[mid+1]]) return;
        merge(nums, l, r, mid);
    }

    void merge(int[] nums, int l, int r, int mid) {
        for(int i = l; i <= r; i++) temp[i] = idx[i];
        int i = l, j = mid + 1;
        for(int k = l; k <= r; k++) {
            if(i > mid) {
                idx[k] = temp[j++];
            } else if(j > r) {
                idx[k] = temp[i++];
                counter[idx[k]] += r-mid;
            } else if(nums[temp[i]] <= nums[temp[j]]) {
                //保证相等情况下左边先出，不影响右边已出的个数
                idx[k] = temp[i++];
                counter[idx[k]] += j-mid-1;
            } else {
                idx[k] = temp[j++];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountSmaller().countSmaller(new int[]{5,2,6,1}));
    }
}
