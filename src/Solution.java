import jdk.jshell.spi.SPIResolutionException;

import java.util.*;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) ans++;
            for (int j = i - 1; j >= 0; j--) {
                if ((nums[j] & nums[i]) == nums[j]) {
                    if (nums[j] == k) ans += j;
                    break;
                }
                nums[j] &= nums[i];
            }
        }
        return ans;
    }
}