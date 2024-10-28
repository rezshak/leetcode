// https://leetcode.com/problems/subsets/

package main

import (
	"fmt"
)

// T: O(n2^n), S: O(n)
func subsets(nums []int) [][]int {
	var result [][]int
	var curr []int
	backtrack(0, nums, &result, &curr)
	return result
}

func backtrack(start int, nums []int, result *[][]int, curr *[]int) {
	// Make a copy of curr and add it to the result
	temp := make([]int, len(*curr))
	copy(temp, *curr)
	*result = append(*result, temp)

	for i := start; i < len(nums); i++ {
		*curr = append(*curr, nums[i])
		backtrack(i+1, nums, result, curr)
		*curr = (*curr)[:len(*curr)-1]
	}
}

// T: O(2^n), S: O(n2^n)
func subsetsBitmask(nums []int) [][]int {
	n := len(nums)
	totalSubsets := 1 << n // 2^n total subsets
	var result [][]int

	for i := 0; i < totalSubsets; i++ {
		var curr []int
		for j := 0; j < n; j++ {
			// If the j-th bit in i is set, include nums[j] in the current subset.
			if i&(1<<j) != 0 {
				curr = append(curr, nums[j])
			}
		}
		result = append(result, curr)
	}
	return result
}

func main() {
	nums1 := []int{1, 2, 3}
	nums2 := []int{0}

	fmt.Println(subsets(nums1))        // [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
	fmt.Println(subsets(nums2))        // [[],[0]]
	fmt.Println(subsetsBitmask(nums1)) // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	fmt.Println(subsetsBitmask(nums2)) // [[],[0]]
}
