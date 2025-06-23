package Tools;


class BinaryIndexedTreesSum { // 树状数组 Sum

    public static int n;
    public static int[] d;

    public BinaryIndexedTreesSum(int[] nums) {
        n = nums.length + 1;
        d = new int[n];
        for (int i = 0; i < n - 1; i++) update(i, nums[i]);
    }

    public int query(int i) { // 区间查询
        int ret = 0;
        for (++i; i > 0; i &= i - 1) ret += d[i];
        return ret;
    }

    public int query(int i, int j) { // 区间查询
        return query(j) - query(i - 1);
    }

    public void update(int i, int k) { // 单点更新
        for (++i; i < n; i += i & -i) d[i] += k;
    }
}