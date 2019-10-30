package leetcode;

import java.util.Arrays;

/**
 * Created by CC on 2017/3/14.
 * Example 1:
 Input: [1,2,3],[2]
 Output: 1
 Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 */
public class L475 {
    public static int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(heaters);
        for(int house : houses){
            int index = Arrays.binarySearch(heaters,house);
            if(index < 0) index = -(index+1);//如果没找到，返回插入点
            // index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1)
            int des1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;//最大值表示边界条件只取一边的时候保证取到那边
            int des2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            res = Math.max(res,Math.min(des1,des2));
        }
        return res;
    }

    public static void main(String[] args) {
        int [] houses = {1,2,3};
        int [] heaters = {2};
        System.out.println(findRadius(houses,heaters));
    }
    static int binarySearch(int [] array , int key){
        int left = 0;
        int right = array.length-1;
        int mid = -1;
        while(left < right){
            mid = (left+right)/2;
            if (array[mid] == key) return key;
            else if(array[mid] > key) right = mid - 1;
            else  left = mid +1;

        }
        return mid ;
    }
}
