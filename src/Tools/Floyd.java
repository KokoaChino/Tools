package Tools;


public class Floyd {
    public void floyd(int[][] mat) { // Floyd全源最短路算法
        int n = mat.length;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
    }
}