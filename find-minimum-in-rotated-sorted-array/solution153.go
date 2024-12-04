// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

package main

import (
	"fmt"
)

// T: O(logn), S: O(1)
func findMin(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}

	left, right := 0, n-1

	if nums[right] > nums[0] {
		return nums[0]
	}

	for left <= right {
		mid := left + (right-left)/2

		if nums[mid] > nums[mid+1] {
			return nums[mid+1]
		}

		if nums[mid] < nums[mid-1] {
			return nums[mid]
		}

		if nums[mid] > nums[0] {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return -1
}

func main() {
	nums1 := []int{3, 4, 5, 1, 2}
	nums2 := []int{4, 5, 6, 7, 0, 1, 2}
	nums3 := []int{11, 13, 15, 17}
	fmt.Println(findMin(nums1)) // 1
	fmt.Println(findMin(nums2)) // 0
	fmt.Println(findMin(nums3)) // 11
}
