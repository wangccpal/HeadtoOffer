package leetcode;

import java.util.*;

public class LTTest2 {
    public int numWays(int n, int[][] relation, int k) {
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap();
        for(int[] s : relation) {
            List<Integer> list = null;
            if(!map.containsKey(s[0])) {
                list = new ArrayList();
                map.put(s[0], list);
            } else {
                list = map.get(s[0]);
            }
            list.add(s[1]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i : map.get(0)) {
            q.offer(i);
        }
        for(int i = 1; i < k; i++) {
            int size = q.size();
            while(size-- > 0) {
                int node = q.poll();
                if(!map.containsKey(node)) continue;
                for(int j : map.get(node)) {
                    q.offer(j);
                }
            }
        }
        while(!q.isEmpty()) {
            if(q.poll() == n-1) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new LTTest2().numWays(5, new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}}, 3);
        System.out.println(i);
    }
}
