// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/

package main

import (
	"fmt"
)

// T: O(n^2), S: O(n)
func incremovableSubarrayCount(nums []int) int {
	n := len(nums)
	count := 0
	for i := 0; i < n; i++ {
		for j := i; j < n; j++ {
			if isStrictlyIncreasing(removeSubarray(nums, i, j)) {
				count++
			}
		}
	}
	return count
}

func removeSubarray(nums []int, start, end int) []int {
	n := len(nums)
	result := make([]int, 0, n-(end-start+1))
	for i := 0; i < start; i++ {
		result = append(result, nums[i])
	}
	for i := end + 1; i < n; i++ {
		result = append(result, nums[i])
	}
	return result
}

func isStrictlyIncreasing(arr []int) bool {
	for i := 0; i < len(arr)-1; i++ {
		if arr[i] >= arr[i+1] {
			return false
		}
	}
	return true
}

func main() {
	nums1 := []int{1, 2, 3, 4}
	nums2 := []int{6, 5, 7, 8}
	nums3 := []int{8, 7, 6, 6}
	fmt.Println(incremovableSubarrayCount(nums1)) // 10
	fmt.Println(incremovableSubarrayCount(nums2)) // 7
	fmt.Println(incremovableSubarrayCount(nums3)) // 3
}
