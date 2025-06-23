package Tools;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;


class MonotoneStack { // 单调栈

    public static int[] lastSmallerElement(int[] nums) { // 上一个更小元素
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) stack.pop();
            if(!stack.isEmpty()) ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static int[] lastBiggerElement(int[] nums) { // 上一个更大元素
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) stack.pop();
            if(!stack.isEmpty()) ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static int[] nextSmallerElement(int[] nums) { // 下一个更小元素
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) stack.pop();
            if(!stack.isEmpty()) ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static int[] nextBiggerElement(int[] nums) { // 下一个更大元素
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) stack.pop();
            if(!stack.isEmpty()) ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}