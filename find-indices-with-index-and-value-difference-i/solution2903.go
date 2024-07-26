// https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/

package main

import (
	"fmt"
	"math"
)

// T: O(n^2), S: O(1)
func findIndices(nums []int, idxDiff int, valDiff int) []int {
	n := len(nums)
	for i := 0; i < n-idxDiff; i++ {
		for j := i + idxDiff; j < n; j++ {
			if int(math.Abs(float64(nums[i])-float64(nums[j]))) >= valDiff {
				return []int{i, j}
			}
		}
	}
	return []int{-1, -1}
}

// T: O(n), S: O(1)
func findIndicesOpt(nums []int, idxDiff int, valDiff int) []int {
	n := len(nums)
	min, max := 0, 0
	for i := idxDiff; i < n; i++ {
		if nums[i-idxDiff] < nums[min] {
			min = i - idxDiff
		}
		if nums[i-idxDiff] > nums[max] {
			max = i - idxDiff
		}
		if nums[i]-nums[min] >= valDiff {
			return []int{min, i}
		}
		if nums[max]-nums[i] >= valDiff {
			return []int{max, i}
		}
	}
	return []int{-1, -1}
}

func main() {
	nums1 := []int{5, 1, 4, 1}
	nums2 := []int{2, 1}
	nums3 := []int{1, 2, 3}
	nums4 := []int{0}
	fmt.Println(findIndices(nums1, 2, 4))    // [0, 3]
	fmt.Println(findIndicesOpt(nums1, 2, 4)) // [0, 3]
	fmt.Println(findIndices(nums2, 0, 0))    // [0, 1]
	fmt.Println(findIndicesOpt(nums2, 0, 0)) // [0, 1]
	fmt.Println(findIndices(nums3, 2, 4))    // [-1, -1]
	fmt.Println(findIndicesOpt(nums3, 2, 4)) // [-1, -1]
	fmt.Println(findIndices(nums4, 0, 0))    // [0, 0]
	fmt.Println(findIndicesOpt(nums4, 0, 0)) // [0, 0]
}
