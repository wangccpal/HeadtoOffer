package com.company.DP;

import java.util.Arrays;

/**
 * Created by CC on 2017/4/4.
 * 01背包问题，价值1，2，5，重量1，2，3，限定容量为5怎么让价值最大？
 * 完全背包问题与01背包的区别是，一维数组里放的是上一个循环的值（v从N-0，01背包）或者是这个循环的（v从0-N，完全背包）。
 * 如果需要输出选择方案，可直接比较d[i][j]==d[i-1][j-weight[i]]+value[i],如果优化了空间复杂度则需要额外一个g[][]来记录方案
 */
public class Pack01 {
    public static void main(String[] args) {
//        packOpt();
        pack();
    }

    public static void pack() {
        //注意初始化的问题，在有用的数据前一行和前一列加了0；
        int[] weight = { 0,1, 2, 3};
        int[] price = { 0,1, 2, 5};
        int v = 6;

        int[][] d = new int[weight.length][v + 1];
        int sum = 0;
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= v; j++) {
//                if(j-weight[i]<0) continue;//保证数组不越界,但是会跳过一些值。
                if (j - weight[i] < 0) d[i][j] = d[i - 1][j];//完美
                else d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - weight[i]] + price[i]);
            }
        }
        for (int j = 0; j < weight.length; j++) {

            System.out.println(Arrays.toString(d[j]));
        }
        for(int i=weight.length-1,j=v;i>0;i--){
            if(d[i][j]>d[i-1][j-weight[i]]) System.out.println("使用了第" + (i) + "件物品");
            j=j-weight[i];
        }
    }

    public static void packOpt() {//优化空间复杂度
        //注意初始化的问题，在有用的数据前一行和前一列加了0；
        int[] weight = { 1, 2, 3};
        int[] price = {1, 2, 5};
        int v = 5;
        int[][] g = new int[weight.length][v+1];//根据这个矩阵输出取了哪些物品

        int[] d = new int[v + 1];
        for (int i = 0; i < weight.length; i++) {
            for(int j=v;j>0;j--){//01背包的循环,从v开始就只放一次。
//            for (int j = 0; j <=v; j++) {//完全背包，一个东西可以不止放一次，第一次循环只放第一个物品，所以从0开始可以放多次
                if (j - weight[i] < 0) continue;//保证数组不越界
                if(d[j - weight[i]] + price[i]>d[j]) g[i][j] = 1;
                d[j] = Math.max(d[j], d[j - weight[i]] + price[i]);
            }
        }
        System.out.println(Arrays.toString(d));
        for(int i=weight.length-1,j=v;i>=0;i--){
            if(g[i][j]==1) System.out.println("使用了第" + (i+1) + "件物品");
            j=j-weight[i];
        }
    }
}