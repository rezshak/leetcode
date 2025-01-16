// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

class Solution347 {

    // Using Bucket Sort
    // T: O(n), S: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        var counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create bucket list where index represents frequency
        var buckets = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        // Step 3: Put numbers in buckets based on their frequency
        for (int num : counts.keySet()) {
            int frequency = counts.get(num);
            buckets.get(frequency).add(num);
        }

        // Step 4: Build result array from most frequent to least
        var result = new int[k];
        for (int i = buckets.size() - 1, j = 0; i >= 0 && j < k; i--) {
            for (int num : buckets.get(i)) {
                if (j < k) {
                    result[j++] = num;
                } else {
                    break;
                }
            }
        }

        return result;
    }

    // Using HashMap and PriorityQueue (Min Heap)
    // T: O(n log k), S: O(n)
    public int[] topKFrequentMinHeap(int[] nums, int k) {
        // Step 1: Count frequencies using HashMap
        var counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use min heap to keep track of k most frequent elements
        var minHeap = new PriorityQueue<Integer>((a, b) -> counts.get(a) - counts.get(b));

        for (int num : counts.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Build result array
        var result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        var sol = new Solution347();
        var nums1 = new int[] { 1, 1, 1, 2, 2, 3 };
        var nums2 = new int[] { 1 };
        System.out.println(Arrays.toString(sol.topKFrequent(nums1, 2))); // [1, 2]
        System.out.println(Arrays.toString(sol.topKFrequentMinHeap(nums1, 2))); // [1, 2]
        System.out.println(Arrays.toString(sol.topKFrequent(nums2, 1))); // [1]
        System.out.println(Arrays.toString(sol.topKFrequentMinHeap(nums2, 1))); // [1]
    }

}
