// https://leetcode.com/problems/interval-list-intersections/

package main

import (
	"fmt"
)

// T: O(n+m), S: O(min(n, m))
func intervalIntersection(list1 [][]int, list2 [][]int) [][]int {
	result := [][]int{}
	p1, p2 := 0, 0
	for p1 < len(list1) && p2 < len(list2) {
		start1, end1 := list1[p1][0], list1[p1][1]
		start2, end2 := list2[p2][0], list2[p2][1]
		if end1 < start2 {
			p1++
		} else if end2 < start1 {
			p2++
		} else {
			start := max(start1, start2)
			end := min(end1, end2)
			result = append(result, []int{start, end})
			if end1 < end2 {
				p1++
			} else {
				p2++
			}
		}
	}
	return result
}

func main() {
	list1 := [][]int{{0, 2}, {5, 10}, {13, 23}, {24, 25}}
	list2 := [][]int{{1, 5}, {8, 12}, {15, 24}, {25, 26}}
	// [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
	fmt.Println(intervalIntersection(list1, list2))
	list1 = [][]int{{1, 3}, {5, 9}}
	list2 = [][]int{}
	// []
	fmt.Println(intervalIntersection(list1, list2))
}
