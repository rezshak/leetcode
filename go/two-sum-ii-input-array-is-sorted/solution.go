// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package main

import "fmt"

// T: O(n), S: O(1)
func twoSum(nums []int, target int) []int {
	left, right := 0, len(nums)-1
	for left < right {
		currSum := nums[left] + nums[right]
		if currSum == target {
			return []int{left + 1, right + 1}
		}
		if currSum < target {
			left++
		} else if currSum > target {
			right--
		}
	}
	return []int{-1, -1}
}

func main() {
	var nums1 = []int{2, 7, 11, 15}
	var nums2 = []int{2, 3, 4}
	var nums3 = []int{-1, 0}
	fmt.Println(twoSum(nums1, 9))  // [1,2]
	fmt.Println(twoSum(nums2, 6))  // [1,3]
	fmt.Println(twoSum(nums3, -1)) // [1,2]
}
