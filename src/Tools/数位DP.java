package Tools;

import java.util.HashMap;
import java.util.Map;


class DigitalDP {

    private Map<String, Integer> cache = new HashMap<>();
    private String s;

    public int digitalDP(int n) { // 数位 DP 通用模板
        s = Integer.toString(n);
        return dfs(0, true, false);
    }

    private int dfs(int i, boolean isLimit, boolean isNum) {
        if (i == s.length()) return isNum ? 1 : 0;
        String key = i + " " + isLimit + " " + isNum;
        if (cache.containsKey(key)) return cache.get(key);
        int ret = 0;
        if (!isNum) ret = dfs(i + 1, false, false);
        int up = isLimit ? (s.charAt(i) - '0') : 9;
        for (int j = (isNum ? 0 : 1); j <= up; j++)
            ret += dfs(i + 1, j == up && isLimit, true);
        cache.put(key, ret);
        return ret;
    }
}