package leetcode;

import java.util.Arrays;

/**
 * 转换一种思路，每天的资源是升序的，利用剧情需要的资源数在每天的资源里二分查找，最后找到符合三个条件的最大天数即可。
 */
public class LTTest3 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = increase.length;
        int[] res = new int[requirements.length];
        int[] c = new int[n + 1];
        int[] r = new int[n + 1];
        int[] h = new int[n + 1];
        Arrays.fill(res, -1);

        for (int i = 1; i <= n; i++) {
            c[i] = c[i - 1] + increase[i-1][0];
            r[i] = r[i - 1] + increase[i-1][1];
            h[i] = h[i - 1] + increase[i-1][2];
        }

        for (int i = 0; i < requirements.length; i++) {
            int[] quest = requirements[i];
            int index1 = binarySearch(c, 0, n+1, quest[0]);
            if (index1 < 0) continue;
            while (index1 != 0 && c[index1-1] == quest[0]) {
                index1--;
            }

            int index2 = binarySearch(r, index1, n+1, quest[1]);
            if (index2 < 0) continue;
            while (index2 != 0 && r[index2-1] == quest[1]) {
                index2--;
            }

            int index3 = binarySearch(h, index2, n+1, quest[2]);
            if (index3 < 0) continue;
            while (index3 != 0 && h[index3-1] == quest[2]) {
                index3--;
            }

            res[i] = Math.max(index1, Math.max(index2, index3));
        }


        return res;
    }

    /**
     * 改进的二分，如果要查找的v比所有的数都大，return -1；否则如果没找到这个数，返回比v大的第一个数的下标;
     * @param nums
     * @param from
     * @param to
     * @param v
     * @return
     */
    static int binarySearch(int[] nums, int from, int to, int v) {
        if (nums[to-1] < v) return -1;
        int l = from, r = to;
        while(l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > v) r = mid;
            else if (nums[mid] < v) l = mid + 1;
            else return mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] a = {{4,0,8},{7,7,10},{7,9,8},{3,10,1},{8,6,8},{2,2,0},{4,10,8},{1,5,4},{4,4,10},{7,9,8},{3,8,6},{0,0,6},{3,2,9},{4,0,9},{4,8,9},{0,8,2},{5,7,10},{7,10,6},{1,4,6},{3,10,0},{8,2,5},{3,1,0},{7,0,7},{9,10,3},{2,4,2},{2,3,4},{0,7,7},{0,9,4},{9,3,7},{1,10,7},{2,7,2},{3,9,2},{0,9,7},{1,9,10},{3,2,8},{9,9,5},{5,9,7},{1,2,9},{10,5,7},{10,2,6},{8,0,10},{7,9,5},{6,10,3},{1,7,0},{8,2,2},{3,3,6},{0,4,8},{8,0,1},{7,0,6},{6,3,6},{6,0,1},{3,10,6},{9,3,0},{9,4,3},{8,1,6},{10,9,0},{4,5,10},{2,9,6},{8,2,5},{6,9,3},{1,2,1},{3,8,2},{7,9,4},{8,6,7},{10,5,8},{2,6,2},{3,6,9},{4,1,6},{8,10,6},{3,2,1},{0,8,7},{4,6,4},{3,4,8},{3,4,9},{2,8,3},{6,8,9},{8,5,0},{9,9,7},{1,7,4},{8,7,3},{0,9,3},{3,8,10},{4,7,9},{8,8,7},{9,6,9},{8,0,5},{0,4,3},{5,10,3},{9,6,4}};
        int[][] b = {{99,92,57},{53,76,42},{81,18,36},{34,76,33},{55,97,77},{19,41,94},{82,49,99},{97,58,24},{66,47,50},{15,86,67},{43,71,80},{83,29,16},{21,101,57},{19,34,22},{12,30,35},{96,89,94},{42,89,89},{87,98,43},{82,95,68},{97,17,83},{100,87,19},{99,74,73},{87,47,54},{66,11,16},{86,96,21},{63,42,25},{65,35,27},{98,32,88},{54,32,91},{24,15,34},{19,44,16},{40,95,81},{42,52,92},{64,88,58},{33,51,39},{40,26,66},{74,88,96},{46,98,83},{42,60,31},{39,72,85},{65,90,34},{31,24,44},{81,11,27},{34,97,60},{98,54,10},{13,33,42},{58,95,10},{46,50,59},{45,71,40},{11,52,11},{56,27,24},{85,41,72},{10,34,56},{99,38,77},{21,80,100},{50,52,100},{61,55,57},{100,83,36},{71,84,65},{29,86,35},{77,61,49},{76,41,98},{37,99,79},{99,73,86}};
        new LTTest3().getTriggerTime(a, b);
    }
}
