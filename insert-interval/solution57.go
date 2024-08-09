// https://leetcode.com/problems/insert-interval/

package main

import "fmt"

// T: O(n), S: O(n)
func insert(intervals [][]int, newInterval []int) [][]int {
	var result [][]int
	n, i := len(intervals), 0
	for i < n && intervals[i][1] < newInterval[0] {
		result = append(result, intervals[i])
		i++
	}
	for i < n && intervals[i][0] <= newInterval[1] {
		newInterval[0] = min(newInterval[0], intervals[i][0])
		newInterval[1] = max(newInterval[1], intervals[i][1])
		i++
	}
	result = append(result, newInterval)
	for i < n {
		result = append(result, intervals[i])
		i++
	}
	return result
}

func main() {
	var intervals1 = [][]int{{1, 3}, {6, 9}}
	var newInterval1 = []int{2, 5}
	var intervals2 = [][]int{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}
	var newInterval2 = []int{4, 8}
	fmt.Println(insert(intervals1, newInterval1))
	fmt.Println(insert(intervals2, newInterval2))
}
