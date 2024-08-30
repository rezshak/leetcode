// https://leetcode.com/problems/top-k-frequent-elements/

package main

import (
	"container/heap"
	"fmt"
)

type Element struct {
	num   int
	count int
}

type MinHeap []Element

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i].count < h[j].count }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.(Element))
}

func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// T: O(n log k), S: O(n)
func topKFrequent(nums []int, k int) []int {
	counts := make(map[int]int)
	for _, num := range nums {
		counts[num]++
	}

	h := &MinHeap{}
	heap.Init(h)

	for num, count := range counts {
		heap.Push(h, Element{num, count})
		if h.Len() > k {
			heap.Pop(h)
		}
	}

	result := make([]int, k)
	for i := 0; i < k; i++ {
		result[i] = heap.Pop(h).(Element).num
	}

	return result
}

func main() {
	nums1 := []int{1, 1, 1, 2, 2, 3}
	nums2 := []int{1}
	fmt.Println(topKFrequent(nums1, 2)) // Output: [1, 2]
	fmt.Println(topKFrequent(nums2, 1)) // Output: [1]
}
