// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

package main

import (
	"fmt"
	"math"
	"sort"
)

// T: O(n), S: O(1)
func maxProduct(nums []int) int {
	a, b := math.MinInt32, math.MinInt32
	for _, n := range nums {
		if n > a {
			b = a
			a = n
		} else if n > b {
			b = n
		}
	}
	return (a - 1) * (b - 1)
}

// T: O(nlogn), S: O(1)
func maxProductSort(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	max1, max2 := nums[n-1], nums[n-2]
	return (max1 - 1) * (max2 - 1)
}

func main() {
	nums1 := []int{3, 4, 5, 2}
	nums2 := []int{1, 5, 4, 5}
	nums3 := []int{3, 7}
	fmt.Println(maxProduct(nums1))     // 12
	fmt.Println(maxProductSort(nums1)) // 12
	fmt.Println(maxProduct(nums2))     // 16
	fmt.Println(maxProductSort(nums2)) // 16
	fmt.Println(maxProduct(nums3))     // 12
	fmt.Println(maxProductSort(nums3)) // 12
}
