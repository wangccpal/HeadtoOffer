package com.company.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by CC on 2017/3/8.
 */
public class Uglynumber {
    public static int nthUglyNumberBru(int n) {//暴力解法，从1开始加
        if(n<=0) return 0;
        int i = 0;
        int temp = 0;
        for(int count = 0;count < n;){
            i++;
            temp = i;
            while(temp%2==0) temp/=2;
            while(temp%3==0) temp/=3;
            while(temp%5==0) temp/=5;
            if(temp==1) count++;
        }
        return i;
    }

    /**
     * 如果用List的话循环条件就算list的size<n；，但是可能较慢
     * 如果用int[] 更快但是要注意数组越界问题
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {//聪明的解法，快慢指针
        int p2=0,p3=0,p5=0;
        int[] res  = new int[n];
        res[0] =1;
        for(int i = 1;i < n;){
//            res[i] = min;
            int i2 = res[p2]*2;
            int i3 = res[p3]*3;
            int i5 = res[p5]*5;
            int min = Math.min(i2,Math.min(i3,i5));
            if (min == i2) p2++;
            if (min == i3) p3++;
            if (min == i5) p5++;
//            i++;
            res[i++] = min;
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(16));
        System.out.println(Integer.MAX_VALUE);
    }
}
