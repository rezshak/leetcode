// https://leetcode.com/problems/sort-colors/

package main

import "fmt"

// T: O(n), S: O(1)
func sortColors(nums []int) {
	left, mid, right := 0, 0, len(nums)-1
	for mid <= right {
		if nums[mid] == 0 {
			nums[left], nums[mid] = nums[mid], nums[left]
			left++
			mid++
		} else if nums[mid] == 1 {
			mid++
		} else {
			nums[mid], nums[right] = nums[right], nums[mid]
			right--
		}
	}
}

func main() {
	nums1 := []int{2, 0, 2, 1, 1, 0}
	nums2 := []int{2, 0, 1}
	sortColors(nums1)
	sortColors(nums2)
	fmt.Println(nums1) // [0,0,1,1,2,2]
	fmt.Println(nums2) // [0,1,2]
}
