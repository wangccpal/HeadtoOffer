package leetcode;

import util.PrintUtil;

import java.util.Arrays;

public class LTTest4 {
    public int minJump(int[] jump) {
        final int x = Integer.MAX_VALUE;
        int length = jump.length;
        int[][] g = new int[length][length+1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length + 1; j++) {
                //表示弹簧可以往左
                if (i > j) {
                    g[i][j] = 1;
                } else if(i == j) {

                } else if(j == i + jump[i]) {
                    g[i][j] = 1;
                } else if (j == length && i + jump[i] > j) {
                    g[i][j] = 1;
                }
                else {
                    g[i][j] = x;
                }
            }
        }
        System.out.println(PrintUtil.printMatrix(g));
        int v = 0; // 求v点到其他店的最短路径
        int m = g.length+1;

        int[] path = new int[m];//表示最短路的路径
        boolean[] node = new boolean[m];// 表示是否已经算出来这个点的最短距离了
        node[v] = true;// 自己不计算到自己的最小距离
        path[v] = -1;

        int[] dist = new int[m];// 保存源点到其他点的最短距离，不修改邻接矩阵
        //初始化dist
        for (int i = 0; i < dist.length; i++) {
            dist[i] = g[v][i];
        }

        while (true) {
            //首先找到离源点最近的直连点
            int min = Integer.MAX_VALUE;
            int minIndex = -1;//如果for循环结束还是-1表示没有找到有相连的最小边
            for (int i = 0; i < m; i++) {
                if (dist[i] < min && !node[i]) {
                    min = dist[i];
                    minIndex = i;
                }
            }

            //如果不存在就退出；如果存在，就标记它已经被遍历过了，更新剩余未被遍历过的点 与源点 之间的距离
            if (minIndex == -1) break;
            node[minIndex] = true;
            dist[minIndex] = min;
            path[minIndex] = v;
            for (int i = 0; i < m; i++) {
                if (!node[i]) {
                    if (g[minIndex][i] == x) continue;
                    if (dist[i] > dist[minIndex] + g[minIndex][i]) {
                        dist[i] = dist[minIndex] + g[minIndex][i];
                        path[i] = minIndex;
                    }
                }
            }
        }

        return dist[length];
    }

    public static void main(String[] args) {
        int i = new LTTest4().minJump(new int[]{2, 5, 1, 1, 1, 1});
        System.out.println(i);
    }
}
