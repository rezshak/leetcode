// https://leetcode.com/problems/maximum-subarray/

package main

import (
	"fmt"
)

// T: O(n^2), S: O(1)
func maxSubArrayBrute(nums []int) int {
	n := len(nums)
	maxSum := nums[0]
	for i := 0; i < n; i++ {
		currSum := 0
		for j := i; j < n; j++ {
			currSum += nums[j]
			maxSum = max(maxSum, currSum)
		}
	}
	return maxSum
}

// T: O(n), S: O(n)
func maxSubArrayDpOpt(nums []int) int {
	dp := make([]int, len(nums))
	copy(dp, nums)
	for i := 1; i < len(nums); i++ {
		dp[i] = max(nums[i], nums[i]+dp[i-1])
	}
	maxSum := dp[0]
	for _, sum := range dp {
		maxSum = max(maxSum, sum)
	}
	return maxSum
}

// T: O(n), S: O(1)
func maxSubArrayKadane(nums []int) int {
	currSum, maxSum := nums[0], nums[0]
	for i := 1; i < len(nums); i++ {
		currSum = max(nums[i], currSum+nums[i])
		maxSum = max(maxSum, currSum)
	}
	return maxSum
}

func main() {
	nums1 := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	nums2 := []int{1}
	nums3 := []int{5, 4, -1, 7, 8}

	fmt.Println(maxSubArrayBrute(nums1))
	fmt.Println(maxSubArrayDpOpt(nums1))
	fmt.Println(maxSubArrayKadane(nums1))
	fmt.Println()

	fmt.Println(maxSubArrayBrute(nums2))
	fmt.Println(maxSubArrayDpOpt(nums2))
	fmt.Println(maxSubArrayKadane(nums2))
	fmt.Println()

	fmt.Println(maxSubArrayBrute(nums3))
	fmt.Println(maxSubArrayDpOpt(nums3))
	fmt.Println(maxSubArrayKadane(nums3))
}
