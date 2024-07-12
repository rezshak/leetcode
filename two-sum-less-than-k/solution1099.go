// https://leetcode.com/problems/two-sum-less-than-k/

package main

import (
	"fmt"
	"sort"
)

// T: O(nlogn) S: O(1)
func twoSumLessThanK(nums []int, k int) int {
	sort.Ints(nums)
	left, right := 0, len(nums)-1
	ans := -1
	for left < right {
		sum := nums[left] + nums[right]
		if sum < k {
			ans = max(ans, sum)
			left++
		} else {
			right--
		}
	}
	return ans
}

func main() {
	nums1 := []int{34, 23, 1, 24, 75, 33, 54, 8}
	nums2 := []int{10, 20, 30}
	fmt.Println(twoSumLessThanK(nums1, 60)) // 58
	fmt.Println(twoSumLessThanK(nums2, 15)) // -1
}
