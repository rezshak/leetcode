// https://leetcode.com/problems/contains-duplicate/

package main

import (
	"fmt"
	"sort"
)

// T: O(n), S: O(n)
func containsDuplicate(nums []int) bool {
	seen := make(map[int]bool)
	for _, n := range nums {
		if seen[n] {
			return true
		}
		seen[n] = true
	}
	return false
}

// T: O(n log n), S: O(1)
func containsDuplicateSort(nums []int) bool {
	sort.Ints(nums)
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1] {
			return true
		}
	}
	return false
}

func main() {
	var nums1 = []int{1, 2, 3, 1}
	var nums2 = []int{1, 2, 3, 4}
	fmt.Println(containsDuplicate(nums1))     // true
	fmt.Println(containsDuplicateSort(nums1)) // true
	fmt.Println(containsDuplicate(nums2))     // false
	fmt.Println(containsDuplicateSort(nums2)) // false
}
