package Tools;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class UnionFindSet {
    // 并查集
    public final int n;
    public int[] fa, rank, num;

    public UnionFindSet(final int n) {
        this.n = n;
        this.fa = new int[n];
        this.rank = new int[n];
        this.num = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        Arrays.fill(rank, 1);
        Arrays.fill(num, 1);
    }
    public UnionFindSet(final int n, final int initial) {
        this.n = n;
        this.fa = new int[n];
        this.rank = new int[n];
        this.num = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i + initial;
        Arrays.fill(rank, 1);
        Arrays.fill(num, 1);
    }

    public int find(int x) { // 查找元素x所在集合的代表元素
        if (x == fa[x]) return x;
        fa[x] = find(fa[x]);
        return fa[x];
    }

    public void union(int i, int j) { // 合并元素i和j所在的集合
        int x = find(i), y = find(j);
        if (rank[x] <= rank[y]) fa[x] = y;
        else fa[y] = x;
        if (rank[x] == rank[y] && x != y) rank[y]++;
        if (x != y) num[x] = num[y] = num[x] + num[y];
    }

    public boolean check(int i, int j) { // 判断元素i和j是否属于同一集合
        return find(i) == find(j);
    }

    public int number(int x) { // 查询元素x所在集合的元素个数
        return num[find(x)];
    }

    public int total() { // 查询不同集合的总数
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            fa[i] = find(i);
            set.add(fa[i]);
        }
        return set.size();
    }
}
