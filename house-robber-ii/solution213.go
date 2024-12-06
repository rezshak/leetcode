// https://leetcode.com/problems/house-robber-ii/

package main

import "fmt"

// T: O(n), S: O(1)
func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	if len(nums) == 1 {
		return nums[0]
	}

	if len(nums) == 2 {
		return max(nums[0], nums[1])
	}

	max1 := robSimple(nums, 0, len(nums)-2)
	max2 := robSimple(nums, 1, len(nums)-1)

	return max(max1, max2)
}

func robSimple(nums []int, start, end int) int {
	prev1 := max(nums[start], nums[start+1])
	prev2 := nums[start]

	for i := start + 2; i <= end; i++ {
		curr := max(prev1, nums[i]+prev2)
		prev2 = prev1
		prev1 = curr
	}

	return prev1
}

func main() {
	nums1 := []int{2, 3, 2}
	nums2 := []int{1, 2, 3, 1}
	nums3 := []int{1, 2, 3}
	nums4 := []int{0, 0}
	fmt.Println(rob(nums1))
	fmt.Println(rob(nums2))
	fmt.Println(rob(nums3))
	fmt.Println(rob(nums4))
}
