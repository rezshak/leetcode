// https://leetcode.com/problems/product-of-array-except-self/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func productExceptSelf(nums []int) []int {
	n := len(nums)
	ans := make([]int, n)
	left := make([]int, n)
	right := make([]int, n)
	left[0] = 1
	for i := 1; i < n; i++ {
		left[i] = nums[i-1] * left[i-1]
	}
	right[n-1] = 1
	for i := n - 2; i >= 0; i-- {
		right[i] = nums[i+1] * right[i+1]
	}
	for i := 0; i < n; i++ {
		ans[i] = left[i] * right[i]
	}
	return ans
}

// T: O(n), S: O(1)
func productExceptSelfOpt(nums []int) []int {
	n := len(nums)
	ans := make([]int, n)
	ans[0] = 1
	for i := 1; i < n; i++ {
		ans[i] = nums[i-1] * ans[i-1]
	}
	right := 1
	for i := n - 1; i >= 0; i-- {
		ans[i] *= right
		right *= nums[i]
	}
	return ans
}

func main() {
	nums1 := []int{1, 2, 3, 4}
	nums2 := []int{-1, 1, 0, -3, 3}
	fmt.Println(productExceptSelf(nums1))    // [24, 12, 8, 6]
	fmt.Println(productExceptSelfOpt(nums1)) // [24, 12, 8, 6]
	fmt.Println(productExceptSelf(nums2))    // [0, 0, 9, 0, 0]
	fmt.Println(productExceptSelfOpt(nums2)) // [0, 0, 9, 0, 0]
}
