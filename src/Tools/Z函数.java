package Tools;


class ZFunction {

    public static int[] calZ(String s) { // Z 函数
        int n = s.length();
        int[] z = new int[n];
        z[0] = n;
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