// https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/

package main

import (
	"fmt"
	"math"
	"sort"
)

// T: O(nlogn), S: O(1)
func minimumAverage(nums []int) float64 {
	sort.Ints(nums)
	left, right := 0, len(nums)-1
	minAvg := math.MaxFloat64
	for left < right {
		currAvg := float64(nums[left]+nums[right]) / 2.0
		if currAvg < minAvg {
			minAvg = currAvg
		}
		left++
		right--
	}
	return minAvg
}

func main() {
	nums1 := []int{7, 8, 3, 4, 15, 13, 4, 1}
	nums2 := []int{1, 9, 8, 3, 10, 5}
	nums3 := []int{1, 2, 3, 7, 8, 9}
	fmt.Printf("%.5f\n", minimumAverage(nums1)) // 5.50000
	fmt.Printf("%.5f\n", minimumAverage(nums2)) // 5.50000
	fmt.Printf("%.5f\n", minimumAverage(nums3)) // 5.00000
}
