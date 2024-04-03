// https://leetcode.com/problems/left-and-right-sum-differences/

package main

import (
	"fmt"
	"math"
)

// T: O(n), S: O(n)
func leftRightDifference(nums []int) []int {
	n := len(nums)
	if n == 1 {
		return []int{0}
	}
	diff := make([]int, n)
	rightSum, leftSum := 0, 0
	for _, num := range nums {
		rightSum += num
	}
	for i := 0; i < n; i++ {
		rightSum -= nums[i]
		diff[i] = int(math.Abs(float64(leftSum - rightSum)))
		leftSum += nums[i]
	}
	return diff
}

func main() {
	nums1 := []int{10, 4, 8, 3}
	fmt.Println(leftRightDifference(nums1)) // [15 1 11 22]
	nums2 := []int{1}
	fmt.Println(leftRightDifference(nums2)) // [0]
}
