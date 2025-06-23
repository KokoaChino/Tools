package Tools;

import java.util.Arrays;


class UnionFindSet { // 并查集

    public final int n;
    public int cnt;
    public int[] fa, size;

    public UnionFindSet(final int n) {
        this.n = n;
        fa = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        cnt = n;
        for (int i = 0; i < n; i++) fa[i] = i;
    }

    public int find(int x) { // 查找元素 x 所在集合的代表元素
        if (x == fa[x]) return x;
        fa[x] = find(fa[x]);
        return fa[x];
    }

    public void merge(int i, int j) { // 合并元素 i 和 j 所在的集合
        int x = find(i), y = find(j);
        if (x == y) return;
        if (size[x] <= size[y]) {
            fa[x] = y;
            size[y] += size[x];
        } else {
            fa[y] = x;
            size[x] += size[y];
        }
        cnt--;
    }

    public boolean isSame(int i, int j) { // 判断元素 i 和 j 是否属于同一集合
        return find(i) == find(j);
    }

    public int getSize(int x) { // 查询元素 x 所在集合的元素个数
        return size[find(x)];
    }

    public int getCnt() { // 查询不同集合的个数
        return cnt;
    }
}