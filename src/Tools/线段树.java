package Tools;


class SegmentTree { // 线段树

    private static int n;
    public int[] d, lazy;

    public SegmentTree(int[] nums) {
        n = nums.length;
        d = new int[1 << (33 - Integer.numberOfLeadingZeros(n))];
        lazy = d.clone();
        build(nums, 0, n - 1, 1);
    }

    private void build(int[] nums, int left, int right, int i) { // 建树
        if (left == right) {
            d[i] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        build(nums, left, mid, 2 * i);
        build(nums, mid + 1, right, 2 * i + 1);
        d[i] = d[2 * i] + d[2 * i + 1];
    }

    private int __query(int start, int end, int left, int right, int i) { // 区间查询
        if (left >= start && right <= end) return d[i];
        int ret = 0, mid = left + (right - left) / 2;
        if (lazy[i] != 0 && left != right) {
            d[2 * i] += (mid - left + 1) * lazy[i];
            d[2 * i + 1] += (right - mid) * lazy[i];
            lazy[2 * i] += lazy[i];
            lazy[2 * i + 1] += lazy[i];
            lazy[i] = 0;
        }
        if (start <= mid) ret += __query(start, end, left, mid, 2 * i);
        if (end >= mid + 1) ret += __query(start, end, mid + 1, right, 2 * i + 1);
        return ret;
    }

    private void __update(int start, int end, int k, int left, int right, int i) { // 区间修改
        if (left >= start && right <= end) {
            d[i] += (right - left + 1) * k;
            lazy[i] += k;
            return;
        }
        int mid = left + (right - left) / 2;
        if (lazy[i] != 0 && left != right) {
            d[2 * i] += (mid - left + 1) * lazy[i];
            d[2 * i + 1] += (right - mid) * lazy[i];
            lazy[2 * i] += lazy[i];
            lazy[2 * i + 1] += lazy[i];
            lazy[i] = 0;
        }
        if (start <= mid) __update(start, end, k, left, mid, 2 * i);
        if (end >= mid + 1) __update(start, end, k, mid + 1, right, 2 * i + 1);
        d[i] = d[2 * i] + d[2 * i + 1];
    }

    public int query(int start, int end) { // 区间查询
        return __query(start, end, 0, n - 1, 1);
    }

    public void update(int start, int end, int k) { // 区间修改
        __update(start, end, k, 0, n - 1, 1);
    }
}