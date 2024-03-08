// https://leetcode.com/problems/product-of-array-except-self/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func productExceptSelf(nums []int) []int {
	len := len(nums)
	output := make([]int, len)
	left := make([]int, len)
	right := make([]int, len)
	left[0] = 1
	for i := 1; i < len; i++ {
		left[i] = nums[i-1] * left[i-1]
	}
	right[len-1] = 1
	for i := len - 2; i >= 0; i-- {
		right[i] = nums[i+1] * right[i+1]
	}
	for i := 0; i < len; i++ {
		output[i] = left[i] * right[i]
	}
	return output
}

// T: O(n), S: O(1)
func productExceptSelfOpt(nums []int) []int {
	len := len(nums)
	output := make([]int, len)
	output[0] = 1
	for i := 1; i < len; i++ {
		output[i] = nums[i-1] * output[i-1]
	}
	right := 1
	for i := len - 1; i >= 0; i-- {
		output[i] *= right
		right *= nums[i]
	}
	return output
}

func main() {
	nums1 := []int{1, 2, 3, 4}
	nums2 := []int{-1, 1, 0, -3, 3}
	fmt.Println(productExceptSelf(nums1))    // [24, 12, 8, 6]
	fmt.Println(productExceptSelfOpt(nums1)) // [24, 12, 8, 6]
	fmt.Println(productExceptSelf(nums2))    // [0, 0, 9, 0, 0]
	fmt.Println(productExceptSelfOpt(nums2)) // [0, 0, 9, 0, 0]
}
