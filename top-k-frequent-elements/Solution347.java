// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

class Solution347 {

    // T: O(n log k), S: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        var counts = new HashMap<Integer, Integer>();
        for (var n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a, b) -> a.getValue() - b.getValue());
        for (var entry : counts.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        var result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution347();
        var nums1 = new int[] { 1, 1, 1, 2, 2, 3 };
        var nums2 = new int[] { 1 };
        System.out.println(Arrays.toString(sol.topKFrequent(nums1, 2)));
        System.out.println(Arrays.toString(sol.topKFrequent(nums2, 1)));
    }

}
