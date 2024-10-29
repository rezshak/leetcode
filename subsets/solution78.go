// https://leetcode.com/problems/subsets/

package main

import (
	"fmt"
)

// T: O(n2^n), S: O(n)
func subsets(nums []int) [][]int {
	var result [][]int
	var curr []int
	backtrack(nums, 0, curr, &result)
	return result
}

func backtrack(nums []int, start int, curr []int, result *[][]int) {
	temp := make([]int, len(curr))
	copy(temp, curr)
	*result = append(*result, temp)
	for i := start; i < len(nums); i++ {
		curr = append(curr, nums[i])
		backtrack(nums, i+1, curr, result)
		curr = curr[:len(curr)-1]
	}
}

// T: O(n2^n), S: O(n2^n)
func subsetsBitmask(nums []int) [][]int {
	n := len(nums)
	totalSubsets := 1 << n // 2^n total subsets
	var result [][]int
	for i := 0; i < totalSubsets; i++ {
		var curr []int
		for j := 0; j < n; j++ {
			// If the j-th bit in i is set, include nums[j] in the current subset.
			if getBit(i, j) == 1 {
				curr = append(curr, nums[j])
			}
		}
		result = append(result, curr)
	}
	return result
}

func getBit(num, bit int) int {
	x := 1 << bit
	if num&x == 0 {
		return 0
	}
	return 1
}

// T: O(2^n), S: O(n2^n)
func subsetsIterative(nums []int) [][]int {
	var result [][]int
	result = append(result, []int{})
	for _, num := range nums {
		size := len(result)
		for i := 0; i < size; i++ {
			newSubset := append([]int{}, result[i]...)
			newSubset = append(newSubset, num)
			result = append(result, newSubset)
		}
	}
	return result
}

// T: O(2^n), S: O(n2^n)
func subsetsBrute(nums []int) [][]int {
	var result [][]int
	var curr []int
	generateSubsets(nums, 0, curr, &result)
	return result
}

func generateSubsets(nums []int, index int, curr []int, result *[][]int) {
	if index == len(nums) {
		temp := make([]int, len(curr))
		copy(temp, curr)
		*result = append(*result, temp)
		return
	}
	generateSubsets(nums, index+1, curr, result)
	curr = append(curr, nums[index])
	generateSubsets(nums, index+1, curr, result)
}

func main() {
	nums1 := []int{1, 2, 3}
	nums2 := []int{0}
	fmt.Println(subsets(nums1)) // [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
	fmt.Println(subsetsBitmask(nums1))
	fmt.Println(subsetsIterative(nums1))
	fmt.Println(subsetsBrute(nums1))
	fmt.Println(subsets(nums2)) // [[],[0]]
}
