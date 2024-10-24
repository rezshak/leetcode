// https://leetcode.com/problems/move-zeroes/

package main

import "fmt"

// T: O(n), S: O(1)
func moveZeroes(nums []int) {
	l, n := 0, len(nums)
	for r := 0; r < n; r++ {
		if nums[r] != 0 {
			nums[l] = nums[r]
			l++
		}
	}
	for l < n {
		nums[l] = 0
		l++
	}
}

func main() {
	nums1 := []int{0, 1, 0, 3, 12}
	nums2 := []int{0}
	moveZeroes(nums1)
	moveZeroes(nums2)
	fmt.Println(nums1) // Output: [1 3 12 0 0]
	fmt.Println(nums2) // Output: [0]
}
