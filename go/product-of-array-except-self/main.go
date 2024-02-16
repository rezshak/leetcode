// https://leetcode.com/problems/product-of-array-except-self/description/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func productExceptSelf(nums []int) []int {
	len := len(nums)
	result := make([]int, len)
	for i := range result {
		result[i] = 1
	}

	left, right := 0, len-1
	leftProduct, rightProduct := 1, 1

	for left < len && right >= 0 {
		result[left] *= leftProduct
		result[right] *= rightProduct
		leftProduct *= nums[left]
		rightProduct *= nums[right]
		left++
		right--
	}

	return result
}

func main() {
	nums1 := []int{1, 2, 3, 4} // 24, 12, 8, 6
	fmt.Println(productExceptSelf(nums1))
	nums2 := []int{-1, 1, 0, -3, 3} // 0, 0, 9, 0, 0
	fmt.Println(productExceptSelf(nums2))
}
