// https://leetcode.com/problems/maximum-average-subarray-i/

package main

import (
	"fmt"
	"math"
)

// T: O(n), O(1)
func findMaxAverage(nums []int, k int) float64 {
	var runningSum int
	var runningAvg, maxAvg = 0.0, -math.MaxFloat64
	for i := 0; i < k; i++ {
		runningSum += nums[i]
	}
	runningAvg = float64(runningSum) / float64(k)
	maxAvg = math.Max(maxAvg, runningAvg)
	for i := k; i < len(nums); i++ {
		runningSum -= nums[i-k]
		runningSum += nums[i]
		runningAvg = float64(runningSum) / float64(k)
		maxAvg = math.Max(maxAvg, runningAvg)
	}
	return maxAvg
}

func main() {
	nums1 := []int{1, 12, -5, -6, 50, 3}
	nums2 := []int{5}
	nums3 := []int{-1}
	fmt.Println(findMaxAverage(nums1, 4)) // 12.75000
	fmt.Println(findMaxAverage(nums2, 1)) // 5.00000
	fmt.Println(findMaxAverage(nums3, 1)) // -1.00000
}
