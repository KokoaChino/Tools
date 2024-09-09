package Tools;

import java.util.ArrayList;


public class LIS {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> g = new ArrayList<>();
        for (int x: nums) {
            int i = bisect_left(g, x);
            if (i == g.size()) g.add(x);
            else g.set(i, x);
        }
        return g.size();
    }

    public int bisect_left(ArrayList<Integer> g, int x) {
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