// https://leetcode.com/problems/monotonic-array/

package main

import "fmt"

// T: O(n), S: O(1)
func isMonotonic(nums []int) bool {
	increasing := true
	decreasing := true
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] > nums[i+1] {
			increasing = false
		}
		if nums[i] < nums[i+1] {
			decreasing = false
		}
	}
	return increasing || decreasing
}

func main() {
	nums1 := []int{1, 2, 2, 3}
	nums2 := []int{6, 5, 4, 4}
	nums3 := []int{1, 3, 2}
	fmt.Println(isMonotonic(nums1)) // true
	fmt.Println(isMonotonic(nums2)) // true
	fmt.Println(isMonotonic(nums3)) // false
}
