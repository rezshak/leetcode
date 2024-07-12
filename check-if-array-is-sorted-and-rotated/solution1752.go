// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

package main

import "fmt"

// T: O(n), S: O(1)
func check(nums []int) bool {
	count := 0
	len := len(nums)
	for i := 0; i < len; i++ {
		if nums[i] > nums[(i+1)%len] {
			count++
		}
	}
	return count <= 1
}

func main() {
	nums1 := []int{3, 4, 5, 1, 2}
	nums2 := []int{2, 1, 3, 4}
	nums3 := []int{1, 2, 3}
	fmt.Println(check(nums1)) // true
	fmt.Println(check(nums2)) // false
	fmt.Println(check(nums3)) // true
}
