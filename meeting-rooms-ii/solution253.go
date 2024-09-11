// https://leetcode.com/problems/meeting-rooms-ii/

package main

import (
	"container/heap"
	"fmt"
	"sort"
)

// T: O(nlogn), S: O(n)
func minMeetingRooms(intervals [][]int) int {
	n := len(intervals)
	start := make([]int, n)
	end := make([]int, n)
	for i := 0; i < n; i++ {
		start[i] = intervals[i][0]
		end[i] = intervals[i][1]
	}
	sort.Ints(start)
	sort.Ints(end)
	result, count := 0, 0
	s, e := 0, 0
	for s < n {
		if start[s] < end[e] {
			count++
			s++
		} else {
			e++
			count--
		}
		result = max(result, count)
	}
	return result
}

// T: O(nlogn), S: O(n)
func minMeetingRoomsPq(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	endTimes := &MinHeap{}
	heap.Init(endTimes)
	heap.Push(endTimes, intervals[0][1])

	for i := 1; i < len(intervals); i++ {
		startTime := intervals[i][0]
		if startTime >= (*endTimes)[0] {
			heap.Pop(endTimes)
		}
		heap.Push(endTimes, intervals[i][1])
	}

	return endTimes.Len()
}

type MinHeap []int

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func main() {
	intervals1 := [][]int{{0, 30}, {5, 10}, {15, 20}}
	intervals2 := [][]int{{7, 10}, {2, 4}}
	fmt.Println(minMeetingRooms(intervals1))   // 2
	fmt.Println(minMeetingRoomsPq(intervals1)) // 2
	fmt.Println(minMeetingRooms(intervals2))   // 1
	fmt.Println(minMeetingRoomsPq(intervals2)) // 1
}
