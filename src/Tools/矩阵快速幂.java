package Tools;


class MatrixFastPower { // 矩阵快速幂

    private final static int MOD = (int)1e9 + 7;

    public static int[][] matMul(int[][] a, int[][] b) { // 矩阵乘法 a * b = c
        int m = a.length, t = b.length, n = b[0].length;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < t; k++)
                    c[i][j] = (int) ((c[i][j] + (long) a[i][k] * b[k][j]) % MOD);
        return c;
    }

    public static int[][] matPow(int[][] a, int n) { // 矩阵幂运算 a ^ n = res
        int m = a.length;
        int[][] res = new int[m][m];
        for (int i = 0; i < m; i++)
            res[i][i] = 1;
        while (n > 0) {
            if ((n & 1) != 0) res = matMul(res, a);
            n >>= 1;
            a = matMul(a, a);
        }
        return res;
    }
}