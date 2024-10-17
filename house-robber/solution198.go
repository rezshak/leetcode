// https://leetcode.com/problems/house-robber/

package main

import (
	"fmt"
	"math"
)

// T: O(n), S: O(1)
func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}

	prev1 := int(math.Max(float64(nums[0]), float64(nums[1])))
	prev2 := nums[0]

	for i := 2; i < len(nums); i++ {
		curr := int(math.Max(float64(prev1), float64(nums[i]+prev2)))
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
	dp[1] = int(math.Max(float64(nums[0]), float64(nums[1])))

	for i := 2; i < n; i++ {
		dp[i] = int(math.Max(float64(dp[i-1]), float64(nums[i]+dp[i-2])))
	}

	return dp[n-1]
}

// T: O(n), S: O(n)
func robMemo(nums []int) int {
	memo := make(map[int]int)
	return helper(nums, 0, memo)
}

func helper(nums []int, i int, memo map[int]int) int {
	if i >= len(nums) {
		return 0
	}
	if val, ok := memo[i]; ok {
		return val
	}
	memo[i] = int(math.Max(float64(helper(nums, i+1, memo)), float64(nums[i]+helper(nums, i+2, memo))))
	return memo[i]
}

func main() {
	nums := []int{1, 2, 3, 1}
	fmt.Println(rob(nums))     // 4
	fmt.Println(robDp(nums))   // 4
	fmt.Println(robMemo(nums)) // 4
	nums = []int{2, 7, 9, 3, 1}
	fmt.Println(rob(nums))     // 12
	fmt.Println(robDp(nums))   // 12
	fmt.Println(robMemo(nums)) // 12
}
