// https://leetcode.com/problems/missing-ranges/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func findMissingRanges(nums []int, lower int, upper int) [][]int {
	var result [][]int
	n := len(nums)

	if n == 0 {
		result = append(result, []int{lower, upper})
		return result
	}
	if nums[0] > lower {
		result = append(result, []int{lower, nums[0] - 1})
	}

	// Handle ranges between elements
	for i := 0; i < n-1; i++ {
		curr, next := nums[i], nums[i+1]
		if next-curr > 1 {
			result = append(result, []int{curr + 1, next - 1})
		}
	}

	if nums[n-1] < upper {
		result = append(result, []int{nums[n-1] + 1, upper})
	}

	return result
}

// T: O(n), S: O(1)
func findMissingRangesOpt(nums []int, lower int, upper int) [][]int {
	var result [][]int
	prev := lower - 1
	for i := 0; i <= len(nums); i++ {
		curr := upper + 1
		if i < len(nums) {
			curr = nums[i]
		}
		if curr-prev > 1 {
			result = append(result, []int{prev + 1, curr - 1})
		}
		prev = curr
	}

	return result
}

func main() {
	nums1 := []int{0, 1, 3, 50, 75}
	nums2 := []int{-1}
	fmt.Println(findMissingRanges(nums1, 0, 99))     // [[2,2],[4,49],[51,74],[76,99]]
	fmt.Println(findMissingRangesOpt(nums1, 0, 99))  // [[2,2],[4,49],[51,74],[76,99]]
	fmt.Println(findMissingRanges(nums2, -1, -1))    // []
	fmt.Println(findMissingRangesOpt(nums2, -1, -1)) // []
}
