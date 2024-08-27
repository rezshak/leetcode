// https://leetcode.com/problems/task-scheduler/

package main

import (
	"container/heap"
	"fmt"
	"sort"
)

type MaxHeap []int

func (h MaxHeap) Len() int           { return len(h) }
func (h MaxHeap) Less(i, j int) bool { return h[i] > h[j] }
func (h MaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// T: O(nlogn), S: O(n)
func leastInterval(tasks []byte, n int) int {
	counts := make(map[byte]int)
	for _, task := range tasks {
		counts[task]++
	}

	h := &MaxHeap{}
	heap.Init(h)
	for _, count := range counts {
		heap.Push(h, count)
	}

	time := 0
	for h.Len() > 0 {
		tempList := []int{}
		cycles := n + 1

		for i := 0; i < cycles; i++ {
			if h.Len() > 0 {
				tempList = append(tempList, heap.Pop(h).(int)-1)
			}
		}

		for _, freq := range tempList {
			if freq > 0 {
				heap.Push(h, freq)
			}
		}

		if h.Len() == 0 {
			time += len(tempList)
		} else {
			time += cycles
		}
	}

	return time
}

// T: O(nlogn), S: O(1)
func leastIntervalGreedy(tasks []byte, n int) int {
	counts := make([]int, 26)
	for _, task := range tasks {
		counts[task-'A']++
	}
	sort.Ints(counts)
	maxFreq := counts[25]
	maxFreqCount := 0
	for _, freq := range counts {
		if freq == maxFreq {
			maxFreqCount++
		}
	}
	intervals := (maxFreq-1)*(n+1) + maxFreqCount
	if intervals > len(tasks) {
		return intervals
	}
	return len(tasks)
}

func main() {
	tasks1 := []byte{'A', 'A', 'A', 'B', 'B', 'B'}
	tasks2 := []byte{'A', 'C', 'A', 'B', 'D', 'B'}
	tasks3 := []byte{'A', 'A', 'A', 'B', 'B', 'B'}
	fmt.Println(leastInterval(tasks1, 2))       // 8
	fmt.Println(leastIntervalGreedy(tasks1, 2)) // 8
	fmt.Println(leastIntervalGreedy(tasks2, 1)) // 6
	fmt.Println(leastInterval(tasks2, 1))       // 6
	fmt.Println(leastInterval(tasks3, 3))       // 9
	fmt.Println(leastIntervalGreedy(tasks3, 3)) // 9
}
