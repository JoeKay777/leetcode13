package leetcode13.algorithm.wk07;

/**
 * 并查集模板
 */
public class HW_UF {

    private int count;
    private int[] parent;

    HW_UF(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];  // 压缩
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pp = find(p);
        int qp = find(q);
        if (pp == qp) return;
        parent[pp] = qp;
        count--;
    }

}
