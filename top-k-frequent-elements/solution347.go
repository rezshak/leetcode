// https://leetcode.com/problems/top-k-frequent-elements/

package main

import (
	"container/heap"
	"fmt"
)

// Using Bucket Sort
// T: O(n), S: O(n)
func topKFrequent(nums []int, k int) []int {
	counts := make(map[int]int)
	for _, num := range nums {
		counts[num]++
	}

	buckets := make([][]int, len(nums)+1)
	for i := range buckets {
		buckets[i] = make([]int, 0)
	}

	for num, freq := range counts {
		buckets[freq] = append(buckets[freq], num)
	}

	result := make([]int, 0, k)
	for i := len(buckets) - 1; i >= 0 && len(result) < k; i-- {
		result = append(result, buckets[i]...)
		if len(result) > k {
			result = result[:k]
		}
	}

	return result
}

// MinHeap implementation
type MinHeap struct {
	nums  []int
	freqs map[int]int
}

func (h MinHeap) Len() int            { return len(h.nums) }
func (h MinHeap) Less(i, j int) bool  { return h.freqs[h.nums[i]] < h.freqs[h.nums[j]] }
func (h MinHeap) Swap(i, j int)       { h.nums[i], h.nums[j] = h.nums[j], h.nums[i] }
func (h *MinHeap) Push(x interface{}) { h.nums = append(h.nums, x.(int)) }
func (h *MinHeap) Pop() interface{} {
	old := h.nums
	n := len(old)
	x := old[n-1]
	h.nums = old[0 : n-1]
	return x
}

// Using Min Heap
// T: O(n log k), S: O(n)
func topKFrequentMinHeap(nums []int, k int) []int {
	freqs := make(map[int]int)
	for _, num := range nums {
		freqs[num]++
	}

	h := &MinHeap{nums: make([]int, 0), freqs: freqs}
	heap.Init(h)

	for num := range freqs {
		heap.Push(h, num)
		if h.Len() > k {
			heap.Pop(h)
		}
	}

	result := make([]int, k)
	for i := k - 1; i >= 0; i-- {
		result[i] = heap.Pop(h).(int)
	}

	return result
}

func main() {
	nums1 := []int{1, 1, 1, 2, 2, 3}
	nums2 := []int{1}
	fmt.Println(topKFrequent(nums1, 2))        // [1 2]
	fmt.Println(topKFrequentMinHeap(nums1, 2)) // [1 2]
	fmt.Println(topKFrequent(nums2, 1))        // [1]
	fmt.Println(topKFrequentMinHeap(nums2, 1)) // [1]
}
