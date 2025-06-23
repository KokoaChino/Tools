package Tools;


class Difference {

    public static void oneDifference(int[] nums, int[][] operates) { // 一维差分
        int n = nums.length;
        int[] dif = new int[n + 1];
        for (int[] a: operates) {
            int i = a[0], j = a[1], d = a[2];
            dif[i] += d;
            dif[j + 1] -= d;
        }
        for (int i = 0; i < n; i++) {
            dif[i + 1] += dif[i];
            nums[i] += dif[i];
        }
    }

    public static void twoDifference(int[][] mat, int[][] operates) { // 二维差分
        int m = mat.length, n = mat[0].length;
        int[][] dif = new int[m + 2][n + 2];
        for (int[] a: operates) {
            int x1 = a[0], y1 = a[1], x2 = a[2], y2 = a[3], d = a[4];
            dif[x2 + 2][y2 + 2] += d;
            dif[x1 + 1][y2 + 2] -= d;
            dif[x2 + 2][y1 + 1] -= d;
            dif[x1 + 1][y1 + 1] += d;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dif[i][j] += dif[i - 1][j] + dif[i][j - 1] - dif[i - 1][j - 1];
                mat[i - 1][j - 1] += dif[i][j];
            }
        }
    }
}