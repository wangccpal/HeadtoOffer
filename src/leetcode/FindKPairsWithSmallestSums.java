package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CC on 2017/3/3.
 *
 */
public class FindKPairsWithSmallestSums {
//    public List<int[]> kSmallestPairsWithPQ(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<int []> pq = new PriorityQueue<int []>();
//        List<int []> res = new ArrayList<int[]>();
//        int[] temp = new int[2];
//        while(k-->0){
//            for(int i = 0;i < nums1.length;i++){
//                temp[0] = nums1[i];
//                temp[1] = nums2[0];
//                pq.offer(temp);
//            }
//            res.add(pq.poll() );
//
//        }
//    }
public List<int[]> kSmallestPairs (int[] nums1, int[] nums2, int k) {
        List<int []> res = new ArrayList<int[]>();
        if(nums1.length==0||nums2.length==0||k<=0) return res ;
        int index[] = new int[nums1.length];//按照nums1定义，因为第二个循环是nums1

        while(k-- > 0){
            int min = Integer.MAX_VALUE;//每次循环开始都变成最大值
            int in = -1;
            for(int i = 0; i< nums1.length; i++){
                if(index[i] >= nums2.length) continue;//当k大于m*n时会出发,注意continue和break区别
                if(nums1[i] + nums2[index[i]] < min) {///改变了index【i】，所以用过的最小组合不会再出现
                    min= nums1[i] + nums2[index[i]];
                    in = i;//in代表哪个组合是满足条件的
                }
            }
           if(in==-1) break;
            int[] temp = {nums1[in], nums2[index[in]]};
            index[in]++;//变成1标志nums2数组的哪个数成为本轮输出,然后使用的次数加1
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] l1 = {1,1,2};
        int[] l2 ={1,2,3};
        FindKPairsWithSmallestSums t = new FindKPairsWithSmallestSums();
        for (int[] i :t.kSmallestPairs(l1,l2,10))
        System.out.println(i);
    }
}
