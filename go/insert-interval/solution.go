// https://leetcode.com/problems/insert-interval/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func insert(intervals [][]int, newInterval []int) [][]int {
	var result [][]int
	i := 0
	for i < len(intervals) && intervals[i][1] < newInterval[0] {
		result = append(result, intervals[i])
		i++
	}
	for i < len(intervals) && intervals[i][0] <= newInterval[1] {
		newInterval[0] = min(newInterval[0], intervals[i][0])
		newInterval[1] = max(newInterval[1], intervals[i][1])
		i++
	}
	result = append(result, newInterval)
	for i < len(intervals) {
		result = append(result, intervals[i])
		i++
	}
	return result
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	existingIntervals := [][][]int{
		{{1, 3}, {6, 9}},
		{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
	}

	newIntervals := [][]int{
		{2, 5},
		{4, 8},
	}

	for i := 0; i < len(newIntervals); i++ {
		fmt.Printf("\nExisting intervals: %v\n", existingIntervals[i])
		fmt.Printf("New interval: %v\n", newIntervals[i])
		output := insert(existingIntervals[i], newIntervals[i])
		fmt.Printf("Updated intervals: %v\n", output)
	}
}
