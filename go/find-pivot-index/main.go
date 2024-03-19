// https://leetcode.com/problems/find-pivot-index/

package main

import "fmt"

// T: O(n), S: O(1)
func pivotIndex(nums []int) int {
	totalSum, leftSum := 0, 0
	for _, num := range nums {
		totalSum += num
	}
	for i := 0; i < len(nums); i++ {
		rightSum := totalSum - leftSum - nums[i]
		if leftSum == rightSum {
			return i
		}
		leftSum += nums[i]
	}
	return -1
}

func main() {
	nums1 := []int{1, 7, 3, 6, 5, 6}
	nums2 := []int{1, 2, 3}
	nums3 := []int{2, 1, -1}
	fmt.Println(pivotIndex(nums1)) // 3
	fmt.Println(pivotIndex(nums2)) // -1
	fmt.Println(pivotIndex(nums3)) // 0
}
