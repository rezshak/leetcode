// https://leetcode.com/problems/minimum-size-subarray-sum/

package main

import (
	"fmt"
	"math"
)

// T: O(n), S: O(1)
func minSubArrayLen(target int, nums []int) int {
	minWinSize := math.MaxInt32
	sum, left := 0, 0
	for right, n := range nums {
		sum += n
		for sum >= target {
			currWinSize := right - left + 1
			minWinSize = min(minWinSize, currWinSize)
			sum -= nums[left]
			left++
		}
	}
	if minWinSize == math.MaxInt32 {
		return 0
	}
	return minWinSize
}

func main() {
	nums1 := []int{2, 3, 1, 2, 4, 3}
	nums2 := []int{1, 4, 4}
	nums3 := []int{1, 1, 1, 1, 1, 1, 1, 1}
	fmt.Println(minSubArrayLen(7, nums1))  // 2
	fmt.Println(minSubArrayLen(4, nums2))  // 1
	fmt.Println(minSubArrayLen(11, nums3)) // 0
}
