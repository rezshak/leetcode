// https://leetcode.com/problems/search-in-rotated-sorted-array/

package main

import (
	"fmt"
)

// T: O(logn), S: O(1)
func search(nums []int, target int) int {
	n := len(nums)
	left, right := 0, n-1

	for left <= right {
		mid := left + (right-left)/2
		if nums[mid] == target {
			return mid
		}

		if nums[left] <= nums[mid] {
			if target >= nums[left] && target < nums[mid] {
				right = mid - 1
			} else {
				left = mid + 1
			}
		} else {
			if target > nums[mid] && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		}
	}

	return -1
}

func main() {
	nums1 := []int{4, 5, 6, 7, 0, 1, 2}
	nums2 := []int{4, 5, 6, 7, 0, 1, 2}
	nums3 := []int{1}
	fmt.Println(search(nums1, 0)) // 4
	fmt.Println(search(nums2, 3)) // -1
	fmt.Println(search(nums3, 0)) // -1
}
