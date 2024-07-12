// https://leetcode.com/problems/intersection-of-two-arrays/

package main

import "fmt"

// T: O(n+m), S: O(n+m)
func intersection(nums1 []int, nums2 []int) []int {
	seen := make(map[int]bool)
	result := make([]int, 0)
	for _, n := range nums1 {
		seen[n] = true
	}
	for _, n := range nums2 {
		if seen[n] {
			result = append(result, n)
			seen[n] = false
		}
	}
	return result
}

func main() {
	nums1 := []int{1, 2, 2, 1}
	nums2 := []int{4, 9, 5}
	fmt.Println(intersection(nums1, nums2)) // [2]
	nums1 = []int{4, 9, 5}
	nums2 = []int{9, 4, 9, 8, 4}
	fmt.Println(intersection(nums1, nums2)) // [9,4]
}
