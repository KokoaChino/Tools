import jdk.jshell.spi.SPIResolutionException;

import java.util.*;


class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int left = 1, right = (int) 1e7;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(dist, hour, mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    private boolean check(int[] dist, double hour, int x) {
        int n = dist.length;
        double s = 0;
        for (int i = 0; i < n - 1; i++) {
            s += Math.ceil((double) dist[i] / x);
            if (s > hour) return false;
        }
        s += (double) dist[n - 1] / x;
        return s <= hour;
    }
}