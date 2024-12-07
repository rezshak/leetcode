// https://leetcode.com/problems/maximum-product-subarray/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func maxProduct(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	n := len(nums)
	maxProduct := nums[0]
	currentProduct := 1

	for i := 0; i < n; i++ {
		currentProduct *= nums[i]
		maxProduct = max(maxProduct, currentProduct)

		if currentProduct == 0 {
			currentProduct = 1
		}
	}

	currentProduct = 1
	for i := n - 1; i >= 0; i-- {
		currentProduct *= nums[i]
		maxProduct = max(maxProduct, currentProduct)

		if currentProduct == 0 {
			currentProduct = 1
		}
	}

	return maxProduct
}

// T: O(n), S: O(1)
func maxProductKadane(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	maxSoFar := nums[0]
	minSoFar := nums[0]
	result := maxSoFar

	for i := 1; i < len(nums); i++ {
		curr := nums[i]
		tempMax := max(curr, max(maxSoFar*curr, minSoFar*curr))
		tempMin := min(curr, min(maxSoFar*curr, minSoFar*curr))

		maxSoFar = tempMax
		minSoFar = tempMin

		result = max(result, maxSoFar)
	}

	return result
}

// T: O(n^2), S: O(1)
func maxProductBrute(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	n := len(nums)
	result := nums[0]
	for i := 0; i < n; i++ {
		cur := nums[i]
		result = max(result, cur)
		for j := i + 1; j < n; j++ {
			cur *= nums[j]
			result = max(result, cur)
		}
	}
	return result
}

func main() {
	nums1 := []int{2, 3, -2, 4}
	nums2 := []int{-2, 0, -1}
	fmt.Println(maxProduct(nums1))       // 6
	fmt.Println(maxProductKadane(nums1)) // 6
	fmt.Println(maxProductBrute(nums1))  // 6
	fmt.Println(maxProduct(nums2))       // 0
	fmt.Println(maxProductKadane(nums2)) // 0
	fmt.Println(maxProductBrute(nums2))  // 0
}
