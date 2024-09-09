package Tools;

import java.util.List;
import java.util.ArrayList;


public class StringHash { // 字符串哈希
    public List<Integer> StringHash(String s, String t) { // s：主串 t：目标串
        final int m = s.length(), n = t.length();
        if (m < n) return new ArrayList<>();
        final int BASE = 107, MOD = 1000000007;
        long T = 0, H = 0, S = FastPower(BASE, n, MOD);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            T = (T * BASE + t.charAt(i)) % MOD;
        for (int i = 0; i < n; i++)
            H = (H * BASE + s.charAt(i)) % MOD;
        if (H == T) res.add(0);
        for (int i = 1; i <= m - n; i++) {
            H = ((H * BASE - s.charAt(i - 1) * S + s.charAt(i + n - 1)) % MOD + MOD) % MOD;
            if (H == T) res.add(i);
        }
        return res;
    }

    private long FastPower(int x, int y, int mod) { // 快速幂
        long res = 1;
        while (y != 0) {
            if ((y & 1) != 0) res = res * x % mod;
            y >>= 1;
            x = (int) ((long) x * x % mod);
        }
        return res;
    }
}