package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCountOfRobot {
    public int movingCount(int m, int n, int k) {
        boolean[][] bs = new boolean[m][n];
        int[] xi = {0,0,1,-1};
        int[] yi = {1,-1,0,0};
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0});
        int res = 1;
        bs[0][0] = true;
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            for(int i = 0 ; i< 4; i++) {
                int x = xy[0] + xi[i], y = xy[1] + yi[i];
                if(x < 0 || x >= m || y < 0 || y >= n) continue;
                if(!bs[x][y] && ans(x) + ans(y) <= k) {
                    res++;
                    q.offer(new int[]{x,y});
                }
                bs[x][y] = true;
            }
        }
        return res;
    }

    int ans(int x) {
        return x%10 + (x/10)%10;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCountOfRobot().movingCount(2,2,1));
    }
}
