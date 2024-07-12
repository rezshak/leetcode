// https://leetcode.com/problems/move-zeroes/

package main

import "fmt"

func moveZeroes(nums []int) {
	len := len(nums)
	left, right := 0, 0
	for right < len {
		if nums[right] != 0 {
			nums[left] = nums[right]
			left++
		}
		right++
	}
	for left < len {
		nums[left] = 0
		left++
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
