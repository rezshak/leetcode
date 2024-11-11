// https://leetcode.com/problems/next-permutation/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func nextPermutation(nums []int) {
	i := len(nums) - 2
	for i >= 0 && nums[i] >= nums[i+1] {
		i--
	}

	if i >= 0 {
		j := len(nums) - 1
		for nums[j] <= nums[i] {
			j--
		}
		nums[i], nums[j] = nums[j], nums[i]
	}

	reverse(nums, i+1)
}

func reverse(nums []int, start int) {
	end := len(nums) - 1
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}

func main() {
	nums1 := []int{1, 2, 3}
	nums2 := []int{3, 2, 1}
	nums3 := []int{1, 1, 5}
	nextPermutation(nums1)
	nextPermutation(nums2)
	nextPermutation(nums3)
	fmt.Println(nums1)
	fmt.Println(nums2)
	fmt.Println(nums3)
}
