package Tools;


class LCS {

    public static int longestCommonSubsequence(int[] arr1, int[] arr2) { // 最长公共子序列
        int n = arr2.length;
        int[] f = new int[n + 1];
        for (int x: arr1) {
            int pre = 0;
            for (int j = 0; j < n; j++) {
                int tmp = f[j + 1];
                f[j + 1] = x == arr2[j] ? pre + 1 : Math.max(f[j], f[j + 1]);
                pre = tmp;
            }
        }
        return f[n];
    }

    public static int longestCommonSubsequence(String s, String t) { // 最长公共子序列
        int n = s.length(), m = t.length();
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int j = 0; j < m; j++) {
                int tmp = f[j + 1];
                f[j + 1] = s.charAt(i) == t.charAt(j) ? pre + 1 : Math.max(f[j], f[j + 1]);
                pre = tmp;
            }
        }
        return f[m];
    }
}