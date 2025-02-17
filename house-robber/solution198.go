// https://leetcode.com/problems/house-robber/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}

	prev1 := max(nums[0], nums[1])
	prev2 := nums[0]

	for i := 2; i < len(nums); i++ {
		curr := max(prev1, nums[i]+prev2)
		prev2 = prev1
		prev1 = curr
	}

	return prev1
}

// T: O(n), S: O(n)
func robDp(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	n := len(nums)
	if n == 1 {
		return nums[0]
	}

	dp := make([]int, n)
	dp[0] = nums[0]
	dp[1] = max(nums[0], nums[1])

	for i := 2; i < n; i++ {
		dp[i] = max(dp[i-1], nums[i]+dp[i-2])
	}

	return dp[n-1]
}

// T: O(n), S: O(n)
func robMemo(nums []int) int {
	memo := make(map[int]int)
	return dfsMemo(nums, 0, memo)
}

func dfsMemo(nums []int, i int, memo map[int]int) int {
	if i >= len(nums) {
		return 0
	}
	if val, ok := memo[i]; ok {
		return val
	}
	skip := dfsMemo(nums, i+1, memo)
	rob := nums[i] + dfsMemo(nums, i+2, memo)
	memo[i] = max(skip, rob)
	return memo[i]
}

// T: O(2^n), S: O(n)
func robBrute(nums []int) int {
	return dfsBrute(nums, 0)
}

func dfsBrute(nums []int, i int) int {
	if i >= len(nums) {
		return 0
	}
	skip := dfsBrute(nums, i+1)
	rob := nums[i] + dfsBrute(nums, i+2)
	return max(skip, rob)
}

func main() {
	nums := []int{1, 2, 3, 1}
	fmt.Println(rob(nums))      // 4
	fmt.Println(robDp(nums))    // 4
	fmt.Println(robMemo(nums))  // 4
	fmt.Println(robBrute(nums)) // 4
	nums = []int{2, 7, 9, 3, 1}
	fmt.Println(rob(nums))      // 12
	fmt.Println(robDp(nums))    // 12
	fmt.Println(robMemo(nums))  // 12
	fmt.Println(robBrute(nums)) // 12
}
