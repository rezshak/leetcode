// https://leetcode.com/problems/non-overlapping-intervals/

package main

import (
	"fmt"
	"sort"
)

// T: O(nlogn), S: O(1)
func eraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})

	n := len(intervals)
	nonOverlappingCount := 1
	prevEnd := intervals[0][1]

	for i := 1; i < n; i++ {
		currStart := intervals[i][0]
		if currStart >= prevEnd {
			nonOverlappingCount++
			prevEnd = intervals[i][1]
		}
	}

	return n - nonOverlappingCount
}

func main() {
	intervals1 := [][]int{{1, 2}, {2, 3}, {3, 4}, {1, 3}}
	intervals2 := [][]int{{1, 2}, {1, 2}, {1, 2}}
	intervals3 := [][]int{{1, 100}, {11, 22}, {1, 11}, {2, 12}}
	fmt.Println(eraseOverlapIntervals(intervals1)) // 1
	fmt.Println(eraseOverlapIntervals(intervals2)) // 2
	fmt.Println(eraseOverlapIntervals(intervals3)) // 2
}
