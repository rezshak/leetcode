// https://leetcode.com/problems/find-median-from-data-stream/

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // lower half
    private PriorityQueue<Integer> minHeap; // upper half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Always add to max heap first
        maxHeap.offer(num);

        // Balance the heaps
        minHeap.offer(maxHeap.poll());

        // Ensure max heap always has equal or one more element
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        var mf = new MedianFinder();
        mf.addNum(1); // arr = [1]
        mf.addNum(2); // arr = [1, 2]
        System.out.println(mf.findMedian()); // return 1.5
        mf.addNum(3); // arr[1, 2, 3]
        System.out.println(mf.findMedian()); // return 2.0
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
