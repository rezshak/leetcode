// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package main

import "fmt"

// T: O(n), S: O(1)
func removeDuplicates(nums []int) int {
	k := 0
	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[k] {
			k++
			nums[k] = nums[i]
		}
	}
	return k + 1
}

// T: O(n), S: O(n)
func removeDuplicates2(nums []int) int {
	set := make(map[int]bool)
	k := 0
	for i := 0; i < len(nums); i++ {
		n := nums[i]
		if !set[n] {
			nums[k] = n
			k++
		}
		set[n] = true
	}
	return k
}

func main() {
	nums1 := []int{1, 1, 2}
	nums2 := []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	fmt.Println(removeDuplicates(nums1))  // 2
	fmt.Println(removeDuplicates2(nums1)) // 2
	fmt.Println(removeDuplicates(nums2))  // 5
	fmt.Println(removeDuplicates2(nums2)) // 5
}
