// https://leetcode.com/problems/find-the-difference-of-two-arrays/

package main

import "fmt"

// T: O(n), S: O(n)
func findDifference(nums1 []int, nums2 []int) [][]int {
	set1 := make(map[int]bool)
	set2 := make(map[int]bool)
	var list1 []int
	var list2 []int
	for _, n := range nums1 {
		set1[n] = true
	}
	for _, n := range nums2 {
		set2[n] = true
	}
	for n, _ := range set1 {
		if !set2[n] {
			list1 = append(list1, n)
		}
	}
	for n, _ := range set2 {
		if !set1[n] {
			list2 = append(list2, n)
		}
	}
	return [][]int{list1, list2}
}

func main() {
	nums1 := []int{1, 2, 3, 2}
	nums2 := []int{2, 4, 6, 4}
	fmt.Println(findDifference(nums1, nums2))
}
