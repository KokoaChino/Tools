package Tools;

import java.util.List;
import java.util.ArrayList;


class PalindromicNumber {

    public static int[] getArray(int U) { // 返回所有位于[1, 10 ^ U]内的回文数
        List<Integer> res = new ArrayList<>();
        int base = 1;
        while (base <= Math.pow(10, (U - 1) / 2)) {
            for (int i = base; i < base * 10; i++) {
                int x = i, t = i / 10;
                while (t != 0) {
                    x = x * 10 + t % 10;
                    t /= 10;
                }
                res.add(x);
            }
            if (base <= Math.pow(10, U / 2 - 1)) {
                for (int i = base; i < base * 10; i++) {
                    int x = i, t = i;
                    while (t != 0) {
                        x = x * 10 + t % 10;
                        t /= 10;
                    }
                    res.add(x);
                }
            }
            base *= 10;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}