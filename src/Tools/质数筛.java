package Tools;

import java.util.Arrays;


class PrimeNumberScreening {

    public static boolean[] getPrimes(int n) { // 质数筛
        if (n < 2) return new boolean[n + 1];
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans, true);
        ans[0] = ans[1] = false;
        for (int i = 2; i <= n; i++) {
            if (ans[i]) {
                for (long j = (long) i * i; j <= n; j += i) {
                    ans[(int) j] = false;
                }
            }
        }
        return ans;
    }
}