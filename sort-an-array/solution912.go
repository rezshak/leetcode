// https://leetcode.com/problems/sort-an-array/

package main

import (
	"fmt"
)

// Merge sort
// T: O(n log n), S: O(n)
func sortArray(nums []int) []int {
	if len(nums) <= 1 {
		return nums
	}

	mid := len(nums) / 2
	nums1 := make([]int, mid)
	nums2 := make([]int, len(nums)-mid)

	copy(nums1, nums[:mid])
	copy(nums2, nums[mid:])

	sortArray(nums1)
	sortArray(nums2)
	merge(nums, nums1, nums2)

	return nums
}

func merge(nums []int, nums1 []int, nums2 []int) {
	idx, idx1, idx2 := 0, 0, 0
	len1, len2 := len(nums1), len(nums2)

	for idx1 < len1 && idx2 < len2 {
		if nums1[idx1] <= nums2[idx2] {
			nums[idx] = nums1[idx1]
			idx1++
		} else {
			nums[idx] = nums2[idx2]
			idx2++
		}
		idx++
	}

	for idx1 < len1 {
		nums[idx] = nums1[idx1]
		idx1++
		idx++
	}

	for idx2 < len2 {
		nums[idx] = nums2[idx2]
		idx2++
		idx++
	}
}

func main() {
	nums1 := []int{5, 2, 3, 1}
	result1 := sortArray(nums1)
	fmt.Println(result1)
	nums2 := []int{5, 1, 1, 2, 0, 0}
	result2 := sortArray(nums2)
	fmt.Println(result2)
	nums3 := []int{110, 100, 0}
	result3 := sortArray(nums3)
	fmt.Println(result3)
}
