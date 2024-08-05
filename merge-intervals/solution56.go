// https://leetcode.com/problems/merge-intervals/

package main

import (
	"fmt"
	"sort"
)

// T: O(nlogn), S: O(n)
func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	merged := [][]int{intervals[0]}
	for i := 1; i < len(intervals); i++ {
		prevInterval := merged[len(merged)-1]
		currInterval := intervals[i]
		if currInterval[0] <= prevInterval[1] {
			prevInterval[1] = max(prevInterval[1], currInterval[1])
		} else {
			merged = append(merged, currInterval)
		}
	}
	return merged
}

func main() {
	intervals1 := [][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}
	intervals2 := [][]int{{1, 4}, {4, 5}}
	fmt.Println(merge(intervals1)) // [[1,6],[8,10],[15,18]]
	fmt.Println(merge(intervals2)) // [[1,5]]
}
