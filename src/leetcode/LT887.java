package leetcode;

public class LT887 {
    public int superEggDrop(int K, int N) {
        int[][] res = new int[K+1][N+1];
//        for(int i =1; i <=K; i++) {
//            res[i][1] = 1;
//        }
        for(int i =1; i <=N; i++) {
            res[1][i] = i;
        }
        for(int i = 2; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                int tMinDrop = N * N;
                for(int k = 1; k <= j; k++) {
                    tMinDrop = Math.min(tMinDrop, Math.max(res[i-1][k-1], res[i][j-k]) + 1);
                }
                res[i][j] = tMinDrop;
            }
        }
        return res[K][N];
    }

    public static void main(String[] args) {
        System.out.println(new LT887().superEggDrop(2,100));
    }
}
