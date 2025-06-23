package Tools;

import java.util.Arrays;


class MultiplicativeInverse {

    public static int[] getInv(int n, int MOD) { // 返回所有位于[1, n]的整数在模 MOD 意义下的乘法逆元
        int[] inv = new int[n + 1];
        Arrays.fill(inv, 1);
        for (int i = 2; i <= n; i++)
            inv[i] = (MOD - MOD / i) * inv[MOD % i] % MOD;
        return inv;
    }
}