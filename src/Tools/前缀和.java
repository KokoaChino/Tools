package Tools;


class OnePrefixSum { // 一维前缀和

    public final int[] P;

    public OnePrefixSum(int[] nums) {
        int n = nums.length;
        int[] p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] += p[i] + nums[i];
        }
        P = p;
    }

    public int getSum(int i, int j) { // 区间求和
        return P[j + 1] - P[i];
    }
}

class TwoPrefixSum { // 二维前缀和

    public final int[][] P;

    public TwoPrefixSum(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] p = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i + 1][j + 1] = p[i][j + 1] + p[i + 1][j] - p[i][j] + mat[i][j];
            }
        }
        P = p;
    }

    public int getSum(int x1, int y1, int x2, int y2) { // 区域求和
        return P[x2 + 1][y2 + 1] - P[x1][y2 + 1] - P[x2 + 1][y1] + P[x1][y1];
    }
}