package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @program: test
 * @description: leet 594
 * @author: Wangchenge
 * @create: 2018-06-08
 **/
public class Longest_Harmonious_Subsequence {
    public static int findLHS(int[] nums) {
        int res = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i:nums
             ) {
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }
            else map.put(i,1);
        }
        Map.Entry<Integer,Integer> pre = null;
        for (Map.Entry<Integer,Integer> e:map.entrySet()
             ) {
            if(pre !=null){
                if(Math.abs(pre.getKey() - e.getKey()) > 1) {
                    pre = e;
                    continue;
                }
                else {
                    int sum = pre.getValue() + e.getValue();
                    if(sum > res) res = sum;
                }
            }
            pre = e;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 2, 3, 3, 1, -14, 13, 4}));
    }
}
