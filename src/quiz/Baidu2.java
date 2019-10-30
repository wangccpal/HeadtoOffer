package quiz;

import java.util.Arrays;

/**
 * 某人去打工n天，每天可以干点轻活，重活或者不干活，只有当他前一天不干活时第二天才可能干重活，根据他干的活来发工资；
 * 问 怎么样干活才能拿到最大工资？ 前提：知道每天干多少活给多少工资
 */
public class Baidu2 {
    /**
     *
     * @param numOfDays 干活天数
     * @param taskList 工资列表
     * @return
     */
    public int maxStipend(int numOfDays,int[][] taskList){
        int[] rst = new int[numOfDays];
        rst[0] = taskList[0][1];
        rst[1] = Math.max(rst[0] + taskList[1][0],taskList[1][1]);
        for (int i = 2; i < numOfDays; i++) {
            rst[i] = Math.max(rst[i-1] + taskList[i][0], rst[i-2] + taskList[i][1]);
        }
        System.out.println(Arrays.toString(rst));
        return rst[numOfDays - 1];
    }

    public static void main(String[] args) {
        int numOfDays = 4;
        int[][] taskList = {
                {1,2},
                {4,10},
                {20,21},
                {2,23}
        };
        System.out.println(new Baidu2().maxStipend(numOfDays,taskList) );
    }
}
