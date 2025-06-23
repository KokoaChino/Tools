package Tools;

import java.util.Arrays;


class BinaryIndexedTreesMin { // 树状数组 Min

    public static int n;
    public static int[] a, d;

    public BinaryIndexedTreesMin(int[] nums) {
        n = nums.length + 1;
        a = new int[n];
        d = new int[n];
        Arrays.fill(a, Integer.MAX_VALUE / 3);
        Arrays.fill(d, Integer.MAX_VALUE / 3);
        for (int i = 0; i < n - 1; i++) update(i, nums[i]);
    }

    public int query(int i, int j) { // 区间查询
        int ret = Integer.MAX_VALUE / 3;
        i++; j++;
        while (i <= j) {
            ret = Math.min(ret, a[j--]);
            while (i <= j - (j & -j)) {
                ret = Math.min(ret, d[j]);
                j -= j & -j;
            }
        }
        return ret;
    }

    public void update(int i, int val) { // 单点更新
        a[++i] = val;
        int j = i;
        while (i < n) {
            d[i] = Math.min(d[i], a[j]);
            i += i & -i;
        }
    }
}