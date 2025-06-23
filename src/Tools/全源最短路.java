package Tools;


class Floyd {

    public static void floyd(int[][] mat) { // 全源最短路
        int n = mat.length;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
    }
}