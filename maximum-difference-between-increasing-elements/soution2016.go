// https://leetcode.com/problems/maximum-difference-between-increasing-elements/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func maximumDifference(nums []int) int {
	n := len(nums)
	rightMaxes := make([]int, n)
	rightMaxes[n-1] = nums[n-1]
	for i := n - 2; i >= 0; i-- {
		rightMaxes[i] = max(rightMaxes[i+1], nums[i])
	}
	maxDiff := -1
	for i := 0; i < n; i++ {
		if rightMaxes[i] > nums[i] {
			maxDiff = max(maxDiff, rightMaxes[i]-nums[i])
		}
	}
	return maxDiff
}

// T: O(n), S: O(1)
func maximumDifferenceOpt(nums []int) int {
	n := len(nums)
	rightMax := nums[n-1]
	maxDiff := -1
	for i := n - 2; i >= 0; i-- {
		if nums[i] < rightMax {
			maxDiff = max(maxDiff, rightMax-nums[i])
		}
		rightMax = max(rightMax, nums[i])
	}
	return maxDiff
}

func main() {
	nums1 := []int{7, 1, 5, 4}
	nums2 := []int{9, 4, 3, 2}
	nums3 := []int{1, 5, 2, 10}
	fmt.Println(maximumDifference(nums1))    // 4
	fmt.Println(maximumDifference(nums2))    // -1
	fmt.Println(maximumDifference(nums3))    // 9
	fmt.Println(maximumDifferenceOpt(nums1)) // 4
	fmt.Println(maximumDifferenceOpt(nums2)) // -1
	fmt.Println(maximumDifferenceOpt(nums3)) // 9
}
