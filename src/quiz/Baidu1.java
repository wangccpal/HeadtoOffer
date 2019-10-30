package quiz;

import java.util.Arrays;
//四种分子，ABCD，AB是单原子分子，CD是双原子分子，给出各个原子的重量massABCD。
//求出要求混合成为一个质量为massX的混合物，需要最多 多少个分子。
//优化空间复杂度解法简洁！
public class Baidu1 {

    //完全背包的空间复杂度优化模型，恰好装满初始状态需要设为负无穷
    int findMaxMoleculesSingle(int massA, int massB, int massC, int massD, int massX){
        int[] mass = {massA,massB,massC*2,massD*2};
        int[] q = new int[massX+1];
        for (int i = 1; i < q.length; i++) {//状态初始化为负无穷,除了第一个数是0。为什么是负无穷？因为+了1也还是负无穷啊
            q[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = mass[i]; j < massX+1; j++) {
                q[j] = Math.max(q[j],q[j-mass[i]] + 1);
            }
        }
        System.out.println(Arrays.toString(q));
        return q[massX];
    }

    //完全背包问题，没有优化空间复杂度
    int findMaxMolecules(int massA, int massB, int massC, int massD, int massX){
        int[] mass = {massA,massB,massC*2,massD*2};
        int[][] q = new int[4][massX+1];//如果用二维数组，需要自己初始化第一行；或者多声明一行,从第二行开始循环,。
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i <= massX; i++) {
                if(i%mass[j]==0) q[j][i] = i/massA;
                else q[j][i] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < massX+1; j++) {
                int temp = Integer.MIN_VALUE;
                if(j-mass[i]>=0) {
                    temp = q[i][j - mass[i]] + 1;
                }
                q[i][j] = Math.max(q[i-1][j],temp);
            }

        }
        System.out.println(Arrays.toString(q[0]));
        System.out.println(Arrays.toString(q[1]));
        System.out.println(Arrays.toString(q[2]));
        System.out.println(Arrays.toString(q[3]));
        return q[3][massX];
    }
    public static void main(String[] args) {
        System.out.println(new Baidu1().findMaxMolecules(5,8,5,3,23));
        System.out.println(new Baidu1().findMaxMoleculesSingle(5,8,5,3,23));
    }
}
