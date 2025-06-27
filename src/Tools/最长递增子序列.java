package Tools;

import java.util.ArrayList;


class LIS {

    public static int lengthOfLIS(int[] nums) { // 最长递增子序列
        ArrayList<Integer> g = new ArrayList<>();
        for (int x: nums) {
            int i = bisectLeft(g, x);
            if (i == g.size()) g.add(x);
            else g.set(i, x);
        }
        return g.size();
    }

    public static int bisectLeft(ArrayList<Integer> g, int x) {
        int n = g.size();
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (g.get(mid) < x) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}