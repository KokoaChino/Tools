package Tools;

import java.util.ArrayList;
import java.util.List;


class PrimeFactorization {

    public static List<int[]> getPrimes(int n) { // 质因数分解
        int i = 2;
        List<int[]> ans = new ArrayList<>();
        while (i * i <= n) {
            if (n % i == 0) {
                ans.add(new int[]{i, 0});
                while (n % i == 0) {
                    n /= i;
                    ans.getLast()[1]++;
                }
            }
            i++;
        }
        if (n > 1) ans.add(new int[]{n, 1});
        return ans;
    }
}