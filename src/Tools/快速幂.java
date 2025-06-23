package Tools;


class FastPower {

    public static long fastPower(int x, int y, int mod) { // 快速幂
        long res = 1;
        while (y != 0) {
            if ((y & 1) != 0) res = res * x % mod;
            y >>= 1;
            x = (int) ((long) x * x % mod);
        }
        return res;
    }
}
