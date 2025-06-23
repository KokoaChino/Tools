package Tools;

import java.util.Random;


class StringHash { // 字符串哈希

    private static final int BASE = (int) 8e8 + new Random().nextInt((int) 1e8), MOD = 1070777777;
    private final int[] pow_base, pre_hash;

    public StringHash(String s) {
        int n = s.length();
        this.pow_base = new int[n + 1];
        this.pre_hash = new int[n + 1];
        pow_base[0] = 1;
        for (int i = 0; i < n; i++) {
            pow_base[i + 1] = (int) ((long) pow_base[i] * BASE % MOD);
            pre_hash[i + 1] = (int) (((long) pre_hash[i] * BASE + s.charAt(i)) % MOD);
        }
    }

    public int subHash(int l, int r) { // 计算子字符串的哈希值
        return (int) (((long) pre_hash[r + 1] - (long) pre_hash[l] * pow_base[r - l + 1]) % MOD + MOD) % MOD;
    }
}