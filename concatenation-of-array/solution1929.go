// https://leetcode.com/problems/concatenation-of-array/

package main

import "fmt"

// T: O(n), S: O(n)
func getConcatenation(nums []int) []int {
	n := len(nums)
	ans := make([]int, 2*n)

	for i := 0; i < n; i++ {
		ans[i] = nums[i]
		ans[i+n] = nums[i]
	}

	return ans
}

// T: O(n), S: O(n)
func getConcatenationBuiltin(nums []int) []int {
	return append(nums, nums...)
}

func main() {
	testCases := [][]int{
		{1, 2, 1},
		{1, 3, 2, 1},
		{1, 2, 3, 4},
	}
	for _, testCase := range testCases {
		fmt.Println(getConcatenation(testCase))
	}
	fmt.Println(getConcatenationBuiltin([]int{1, 2, 1}))
}
