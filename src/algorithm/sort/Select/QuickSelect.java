package algorithm.sort.Select;

/**
 * Created by CC on 2017/3/1.
 */
public class QuickSelect {
    public int quickSelect(int [] nums,int lo, int hi, int k){//找第k大
        if(lo<=hi && 0 < k && nums.length+1>k) {
            int x = partition(nums, lo, hi);
            int count = hi - x;// 计算有几个数比x大
            if (k == count + 1) return nums[x];//相当于找第x小
            else if (k > count + 1)
                return quickSelect(nums, lo, x - 1, k - 1 - count);//比nums[k]大的数的数量<k，说明count太小了，在左边找,
                // 第k大的变成了第K-1-count大
            else return quickSelect(nums, x + 1, hi, k);
        }
        return -1;
    }
    int partition(int[] nums ,int lo, int hi){
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
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length-1);
    }

    int find(int[] nums, int k, int l, int r) {
        int lo = l, hi = r+1, p = nums[l];
        while(true) {
            while(++lo < r && nums[lo] < p);
            while(nums[--hi] > p);
            if(lo >= hi) break;
            swap(nums, lo, hi);
        }
        int larger = r-hi;
        if(larger == k-1) return p;
        else if(larger > k-1) return find(nums, k, hi+1, r);
        else return find(nums, k-larger-1, l+1, hi);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,3,6,5};
        System.out.println(new QuickSelect().quickSelect(nums,0, nums.length-1,1));
        System.out.println(new QuickSelect().find(nums,1, 0,nums.length-1));
    }
}
