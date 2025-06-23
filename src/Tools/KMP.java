package Tools;


class KMP {

    public static int kmp(String s, String t) { // s：主串 t：目标串
        int m = s.length(), n = t.length(), j = 0;
        if (n == 0) return -1;
        int[] next = new int[n];
        for (int i = 1; i < n; i++) {
            while (j > 0 && t.charAt(i) != t.charAt(j))
                j = next[j - 1];
            if (t.charAt(i) == t.charAt(j)) j++;
            next[i] = j;
        }
        j = 0;
        for (int i = 0; i < m; i++) {
            while (j > 0 && s.charAt(i) != t.charAt(j))
                j = next[j - 1];
            if (s.charAt(i) == t.charAt(j)) j++;
            if (j == n) return i - n + 1;
        }
        return -1;
    }
}
