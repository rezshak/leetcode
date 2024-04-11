// https://leetcode.com/problems/max-consecutive-ones-iii/

package main

import "fmt"

// T: O(n), S: O(1)
func longestOnes(nums []int, k int) int {
	len := len(nums)
	left, right, zeros, max := 0, 0, 0, 0
	for right < len {
		if nums[right] == 0 {
			zeros++
		}
		right++
		if zeros > k {
			if nums[left] == 0 {
				zeros--
			}
			left++
		}
		if right-left > max {
			max = right - left
		}
	}
	return max
}

func main() {
	nums1 := []int{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}
	nums2 := []int{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}
	fmt.Println(longestOnes(nums1, 2)) // 6
	fmt.Println(longestOnes(nums2, 3)) // 10
}
