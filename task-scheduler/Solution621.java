// https://leetcode.com/problems/task-scheduler/

import java.util.*;

class Solution621 {

    // T: O(nlogn), S: O(n)
    public int leastInterval(char[] tasks, int n) {
        var freqMap = new HashMap<Character, Integer>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap.addAll(freqMap.values());

        int time = 0;

        // Simulate the task execution with a cooldown
        while (!maxHeap.isEmpty()) {
            var tempList = new ArrayList<Integer>();
            int cycles = n + 1; // We need n+1 slots for one full round of execution

            for (int i = 0; i < cycles; i++) {
                if (!maxHeap.isEmpty()) {
                    tempList.add(maxHeap.poll() - 1); // Execute the task and decrement frequency
                }
            }

            // Add back the remaining frequencies to the heap
            for (int freq : tempList) {
                if (freq > 0) {
                    maxHeap.offer(freq);
                }
            }

            // If the heap is empty, we only needed to process exactly as many as tasks
            time += maxHeap.isEmpty() ? tempList.size() : cycles;
        }

        return time;
    }

    // T: O(nlogn), S: O(1)
    public int leastIntervalGreedy(char[] tasks, int n) {
        var counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        Arrays.sort(counts);
        int maxFreq = counts[25];
        int maxFreqCount = 0;
        for (int freq : counts) {
            if (freq == maxFreq) {
                maxFreqCount++;
            }
        }
        // Calculate the minimum intervals required
        int intervals = (maxFreq - 1) * (n + 1) + maxFreqCount;
        return Math.max(intervals, tasks.length);
    }

    public static void main(String[] args) {
        var sol = new Solution621();
        var tasks1 = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        var tasks2 = new char[] { 'A', 'C', 'A', 'B', 'D', 'B' };
        var tasks3 = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
        System.out.println(sol.leastInterval(tasks1, 2)); // 8
        System.out.println(sol.leastIntervalGreedy(tasks1, 2)); // 8
        System.out.println(sol.leastInterval(tasks2, 1)); // 6
        System.out.println(sol.leastIntervalGreedy(tasks2, 1)); // 6
        System.out.println(sol.leastInterval(tasks3, 3)); // 9
        System.out.println(sol.leastIntervalGreedy(tasks3, 3)); // 9
    }

}
