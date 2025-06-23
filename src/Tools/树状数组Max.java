package Tools;

import java.util.Arrays;


class BinaryIndexedTreesMax { // 树状数组 Max

    public static int n;
    public static int[] a, d;

    public BinaryIndexedTreesMax(int[] nums) {
        n = nums.length + 1;
        a = new int[n];
        d = new int[n];
        Arrays.fill(a, Integer.MIN_VALUE / 3);
        Arrays.fill(d, Integer.MIN_VALUE / 3);
        for (int i = 0; i < n - 1; i++) update(i, nums[i]);
    }

    public int query(int i, int j) { // 区间查询
        int ret = Integer.MIN_VALUE / 3;
        i++; j++;
        while (i <= j) {
            ret = Math.max(ret, a[j--]);
            while (i <= j - (j & -j)) {
                ret = Math.max(ret, d[j]);
                j -= j & -j;
            }
        }
        return ret;
    }

    public void update(int i, int val) { // 单点更新
        a[++i] = val;
        int j = i;
        while (i < n) {
            d[i] = Math.max(d[i], a[j]);
            i += i & -i;
        }
    }
}