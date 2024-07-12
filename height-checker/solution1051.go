// https://leetcode.com/problems/height-checker/

package main

import (
	"fmt"
	"sort"
)

// T: O(n log n), S: O(n)
func heightChecker(heights []int) int {
	expected := make([]int, len(heights))
	copy(expected, heights)
	sort.Ints(expected)
	count := 0
	for i := 0; i < len(heights); i++ {
		if heights[i] != expected[i] {
			count++
		}
	}
	return count
}

func main() {
	nums1 := []int{1, 1, 4, 2, 1, 3}
	nums2 := []int{5, 1, 2, 3, 4}
	nums3 := []int{1, 2, 3, 4, 5}
	fmt.Println(heightChecker(nums1)) // 3
	fmt.Println(heightChecker(nums2)) // 5
	fmt.Println(heightChecker(nums3)) // 0
}
