package algorithm;

import java.util.stream.IntStream;

/**
 * 加权并查集, 总是把小树union到大树上面
 */
public class UF {
    private int[] sz; //父链接数组
    private int[] id; //各节点对应连通分量大小
    private int count; //连通分量的数量
    public UF(int N) {
        count = N;
        sz = new int[N];
        id = new int[N];
        IntStream.range(0, N).forEach(x -> sz[x] = x);
        IntStream.range(0, N).forEach(x -> id[x] = x);
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public boolean unionSuccess(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return false;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
        return true;
    }
}
