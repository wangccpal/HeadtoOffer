package head67;

import java.util.ArrayList;

public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length) return null;
        else if(k<=0) return null;
        ArrayList list =new ArrayList<Integer>();
        int loc = partition(input,0,input.length-1,k);
            for(int i=0;i<=loc;i++) list.add(input[i]);
        return list;
    }
  static int partition(int[] nums,int lo,int hi,int k){
       if(lo>=hi) return lo;
        int v = nums[lo];
        int i = lo;
        int j = hi+1;
        while(true){
           while(nums[++i]<v)if(i==hi) break;
           while(nums[--j]>v)if(j==lo) break;
           if(i>=j) break;
		   util.Swap.swap(nums,i,j);
        }
        util.Swap.swap(nums,lo,j);
        if(j+1<k) return partition(nums,j+1,nums.length-1,k);
        else if(j+1>k) return partition(nums,0,j-1,k);
        else return j;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {6,7,5,4,8,1,3,2};
		ArrayList res = GetLeastNumbers_Solution(a,0);
		System.out.println(res);
	}

}
