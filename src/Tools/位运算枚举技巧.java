package Tools;

import java.util.HashSet;
import java.util.Set;


class LogTrick {

    public static Set<Integer> or_list(int[] nums) { // 返回按位或的结果集
        int n = nums.length;
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res.add(nums[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] | nums[i]) == nums[j]) break;
                nums[j] |= nums[i];
                res.add(nums[j]);
            }
        }
        return res;
    }

    public static Set<Integer> and_list(int[] nums) { // 返回按位与的结果集
        int n = nums.length;
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res.add(nums[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] & nums[i]) == nums[j]) break;
                nums[j] &= nums[i];
                res.add(nums[j]);
            }
        }
        return res;
    }
}