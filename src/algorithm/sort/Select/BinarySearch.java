package algorithm.sort.Select;

/**
 * Created by CC on 2017/3/26.
 * 注意先排序
 */
public class BinarySearch {
    public static int binarySearch(int key, int [] nums){//循环
        int start = 0;
        int end = nums.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]>key) end = mid - 1;
            else if(nums[mid]<key) start = mid + 1;
            else return mid;
        }
        return -1;//不存在
    }
    public static int biSearch(int key, int[] nums ,int start,int end){//递归
        if (start > end ) return -1;
        int mid = start + (end - start)/2;
        if(nums[mid] > key) return biSearch(key, nums, start, mid-1);
        else if(nums[mid] < key) return biSearch(key, nums, mid + 1, end);
        else return mid;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
//        int[] nums1 = {5,4,3,2,1};
        System.out.println(binarySearch(0,nums));
        System.out.println(biSearch(0,nums,0,nums.length - 1));
//        System.out.println(binarySearch(4,nums1));
    }
}
