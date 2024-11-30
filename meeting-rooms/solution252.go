// https://leetcode.com/problems/meeting-rooms/

package main

import (
	"fmt"
	"sort"
)

// T: O(nlogn), S: O(1)
func canAttendMeetings(intervals [][]int) bool {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	for i := 1; i < len(intervals); i++ {
		prev := intervals[i-1]
		curr := intervals[i]
		if curr[0] < prev[1] {
			return false
		}
	}

	return true
}

func main() {
	intervals1 := [][]int{{0, 30}, {5, 10}, {15, 20}}
	intervals2 := [][]int{{7, 10}, {2, 4}}
	intervals3 := [][]int{{0, 5}, {5, 10}}
	intervals4 := [][]int{}

	fmt.Println(canAttendMeetings(intervals1)) // false
	fmt.Println(canAttendMeetings(intervals2)) // true
	fmt.Println(canAttendMeetings(intervals3)) // true
	fmt.Println(canAttendMeetings(intervals4)) // true
}
