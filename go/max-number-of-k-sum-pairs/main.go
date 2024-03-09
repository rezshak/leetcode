// https://leetcode.com/problems/max-number-of-k-sum-pairs/

package main

import (
	"fmt"
	"sort"
)

// Time: O(n log n), Space: O(1)
func maxOperations(nums []int, k int) int {
	sort.Ints(nums)
	maxOps := 0
	left, right := 0, len(nums)-1
	for left < right {
		currSum := nums[left] + nums[right]
		if currSum == k {
			maxOps++
			left++
			right--
		} else if currSum < k {
			left++
		} else {
			right--
		}
	}
	return maxOps
}

// Time: O(n), Space: O(n)
func maxOperationsMap(nums []int, k int) int {
	counts := make(map[int]int)
	maxOps := 0
	for _, n := range nums {
		diff := k - n
		if counts[diff] > 0 {
			maxOps++
			counts[diff]--
		} else {
			counts[n]++
		}
	}
	return maxOps
}

func main() {
	nums1 := []int{1, 2, 3, 4}
	nums2 := []int{3, 1, 3, 4, 3}
	fmt.Println(maxOperationsMap(nums1, 5)) // 2
	fmt.Println(maxOperations(nums1, 5))    // 2
	fmt.Println(maxOperationsMap(nums2, 6)) // 1
	fmt.Println(maxOperations(nums2, 6))    // 1
}
