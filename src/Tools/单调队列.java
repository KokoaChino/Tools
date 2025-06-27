package Tools;

import java.util.ArrayDeque;
import java.util.Deque;


class MonotonicQueue { // 单调队列

    public static int[] minSlidingWindow(int[] nums, int k) { // 滑动窗口最小值
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = Math.min(i + k - 1, n - 1);
            if (!q.isEmpty() && q.getFirst() > maxIndex) q.pollFirst();
            while (!q.isEmpty() && nums[i] <= nums[q.getLast()]) q.pollLast();
            q.addLast(i);
            ans[i] = nums[q.getFirst()];
        }
        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) { // 滑动窗口最大值
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int maxIndex = Math.min(i + k - 1, n - 1);
            if (!q.isEmpty() && q.getFirst() > maxIndex) q.pollFirst();
            while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) q.pollLast();
            q.addLast(i);
            ans[i] = nums[q.getFirst()];
        }
        return ans;
    }
}