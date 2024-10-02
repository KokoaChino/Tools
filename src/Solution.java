import jdk.jshell.spi.SPIResolutionException;

import java.util.*;


class Solution {
    public long sumScores(String s) {
        System.out.println(Arrays.toString(calZ(s)));
        return Arrays.stream(calZ(s)).mapToLong(Long::valueOf).sum();
    }

    public int[] calZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) z[i] = Math.min(z[i - l], r - i + 1);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                l = i; r = i + z[i];
                z[i]++;
            }
        }
        return z;
    }
}