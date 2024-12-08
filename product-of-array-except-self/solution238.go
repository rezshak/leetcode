// https://leetcode.com/problems/product-of-array-except-self/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func productExceptSelf(nums []int) []int {
	n := len(nums)
	prefix := make([]int, n)
	left := 1
	for i := 0; i < n; i++ {
		prefix[i] = left
		left *= nums[i]
	}
	postfix := make([]int, n)
	right := 1
	for i := n - 1; i >= 0; i-- {
		postfix[i] = right
		right *= nums[i]
	}
	output := make([]int, n)
	for i := 0; i < n; i++ {
		output[i] = prefix[i] * postfix[i]
	}
	return output
}

// T: O(n), S: O(1)
func productExceptSelfOpt(nums []int) []int {
	n := len(nums)
	output := make([]int, n)
	left, right := 1, 1
	for i := 0; i < n; i++ {
		output[i] = left
		left *= nums[i]
	}
	for i := n - 1; i >= 0; i-- {
		output[i] *= right
		right *= nums[i]
	}
	return output
}

// T: O(n), S: O(1)
func productExceptSelfOpt2(nums []int) []int {
	n := len(nums)
	res := make([]int, n)
	for i := range res {
		res[i] = 1
	}

	leftProduct, rightProduct := 1, 1
	l, r := 0, n-1

	for l < n && r >= 0 {
		res[l] *= leftProduct
		res[r] *= rightProduct

		leftProduct *= nums[l]
		rightProduct *= nums[r]

		l++
		r--
	}

	return res
}

func main() {
	nums1 := []int{1, 2, 3, 4}
	nums2 := []int{-1, 1, 0, -3, 3}
	fmt.Println(productExceptSelf(nums1))     // [24, 12, 8, 6]
	fmt.Println(productExceptSelfOpt(nums1))  // [24, 12, 8, 6]
	fmt.Println(productExceptSelfOpt2(nums1)) // [24, 12, 8, 6]
	fmt.Println(productExceptSelf(nums2))     // [0, 0, 9, 0, 0]
	fmt.Println(productExceptSelfOpt(nums2))  // [0, 0, 9, 0, 0]
	fmt.Println(productExceptSelfOpt2(nums2)) // [0, 0, 9, 0, 0]
}
