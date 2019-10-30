package algorithm.sort;

/**
 * Created by CC on 2017/3/30.
 */
public class Example {
    public static void exch(int[] nums,int i,int j){
        int tmp = nums[i];
        nums [i] = nums[j];
        nums[j] = tmp;
    }

}
