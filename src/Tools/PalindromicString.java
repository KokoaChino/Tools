package Tools;

import java.util.Arrays;


public class PalindromicString {
    public boolean[][] getIsP(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(f[i], true);
        for (int j = 1; j < n; j++)
            for (int i = j - 1; i >= 0; i--)
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
        return f;
    }
}