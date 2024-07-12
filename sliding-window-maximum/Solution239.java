// https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution239 {

    // T: O(n), S: O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offer(i);
            if (i - dq.peekFirst() >= k) {
                dq.pollFirst();
            }
            if (i >= k - 1) {
                result[idx++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    // T: O(nk), S: O(n)
    public int[] maxSlidingWindowBrute(int[] nums, int k) {
        int len = nums.length - k + 1;
        var result = new int[len];
        int p = 0;
        for (int i = 0; i < len; i++) {
            int winMax = maxBrute(nums, i, i + k);
            result[p++] = winMax;
        }
        return result;
    }

    private int maxBrute(int[] nums, int beg, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = beg; i < end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new Solution239();
        var nums1 = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        var result1 = sol.maxSlidingWindow(nums1, 3);
        System.out.println(Arrays.toString(result1)); // [3,3,5,5,6,7]
        var result2 = sol.maxSlidingWindow(nums1, 3);
        System.out.println(Arrays.toString(result2)); // [3,3,5,5,6,7]
    }

}
