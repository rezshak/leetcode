// https://leetcode.com/problems/number-of-distinct-averages/

package main

import (
	"fmt"
	"sort"
)

// T: O(n log n), S: O(n)
func distinctAverages(nums []int) int {
	sort.Ints(nums)
	left, right := 0, len(nums)-1
	set := make(map[float64]bool)
	for left < right {
		min, max := nums[left], nums[right]
		left++
		right--
		avg := float64(min+max) / 2.0
		set[avg] = true
	}
	return len(set)
}

func main() {
	nums1 := []int{4, 1, 4, 0, 3, 5}
	nums2 := []int{1, 100}
	fmt.Println(distinctAverages(nums1)) // 2
	fmt.Println(distinctAverages(nums2)) // 1
}
