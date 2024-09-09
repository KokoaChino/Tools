package Tools;


public class PrefixSum {

    public int[] onePrefixSum(int[] nums) { // 一维前缀和
        int n = nums.length;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ans[i + 1] += ans[i] + nums[i];
        }
        return ans;
    }

    public int getSum(int[] P, int i, int j) { // 区间求和
        return P[j + 1] - P[i];
    }

    public int[][] twoPrefixSum(int[][] mat) { // 二维前缀和
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i + 1][j + 1] = ans[i][j + 1] + ans[i + 1][j] - ans[i][j] + mat[i][j];
            }
        }
        return ans;
    }

    public int getSum(int[][] P, int x1, int y1, int x2, int y2) { // 区域求和
        return P[x2 + 1][y2 + 1] - P[x1][y2 + 1] - P[x2 + 1][y1] + P[x1][y1];
    }
}