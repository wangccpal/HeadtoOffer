package com.company.DP;

import java.util.Arrays;

public class Dijstra {
	public static void main(String[] args) {
		final int x = Integer.MAX_VALUE;
		int[][] g = {
				{0,6,3,x},
				{6,0,2,5},
				{3,2,0,3},
				{x,5,3,0}
		};
		int v = 0; // 求v点到其他店的最短路径
		int m = g.length;
		
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
				if (g[v][i] < min && !node[i]) {
					min = g[v][i];
					minIndex = i;
				}
			}
			
			//如果不存在就退出；如果存在，就标记它已经被遍历过了，更新剩余未被遍历过的点 与源点 之间的距离
			if(minIndex==-1) break;
			node[minIndex] = true;
			dist[minIndex] = min;
			path[minIndex] = v;
			for (int i = 0; i < m; i++) {
				if (!node[i]) {
					if (dist[i] > g[v][minIndex] + g[minIndex][i]) {
						dist[i] = g[v][minIndex] + g[minIndex][i];
						path[i] = minIndex;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(dist));
		for (int i = 0; i < dist.length; i++) {
			int pre = path[i];
			if(pre!=-1) {
				System.out.println(i);
				while(pre!=-1) {
					System.out.println(pre);
					pre = path[pre];
				}
				
			}
			System.out.println("____");
		}
		System.out.println(Arrays.toString(path));
	}
}
