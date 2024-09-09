package Tools;

import java.util.HashMap;


public class Count {
    // 计数

    // 求某个元素在集合中出现的次数
    public static int count(int[] arr, int target) {
        int res = 0;
        for (int x: arr) {
            if (x == target) res++;
        }
        return res;
    }
    public static int count(double[] arr, double target) {
        int res = 0;
        for (double x: arr) {
            if (x == target) res++;
        }
        return res;
    }
    public static int count(char[] arr, char target) {
        int res = 0;
        for (char x: arr) {
            if (x == target) res++;
        }
        return res;
    }
    public static int count(String s, char target) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) res++;
        }
        return res;
    }

    // 得到集合的<元素：该元素在集合中出现的次数>的映射集合
    public static <T> HashMap<T, Integer> counter(T[] arr) {
        HashMap<T, Integer> res = new HashMap<>();
        for (T x: arr) {
            res.put(x, res.getOrDefault(x, 0) + 1);
        }
        return res;
    }
}
