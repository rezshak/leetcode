// https://leetcode.com/problems/sliding-window-maximum/

package SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        var result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peek()]) {
                dq.remove();
            }
            dq.add(i);
        }
        result[idx++] = nums[dq.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            if (dq.peekFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peek()]) {
                dq.remove();
            }

            dq.add(i);
            result[idx++] = nums[dq.peekFirst()];
        }
        return result;
    }

    public int[] findMaxSlidingWindowOpt(int[] nums, int k) {
        int n = nums.length, l = 0, r = Math.min(l + k, n);
        var result = new int[n - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = max(nums, l, r);
            l++;
            r++;
        }
        return result;
    }

    private int max(int[] nums, int l, int r) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = l; i < r; i++) {
            pq.add(nums[i]);
        }
        return pq.poll();
    }

    public int[] maxSlidingWindowBrute(int[] nums, int k) {
        int l = 0, r = k, n = nums.length;
        var result = new ArrayList<Integer>();
        while (r <= n) {
            int max = maxBrute(nums, l++, r++);
            result.add(max);
        }
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    private int maxBrute(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        while (l < r) {
            max = Math.max(max, nums[l++]);
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var nums1 = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        var result1 = sol.maxSlidingWindow(nums1, 3); // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(result1));
    }

}
