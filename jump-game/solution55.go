// https://leetcode.com/problems/jump-game/

package main

import "fmt"

// T: O(n), S: O(1)
func canJump(nums []int) bool {
	if len(nums) == 0 {
		return false
	}

	n := len(nums)
	maxJump := 0

	for i := 0; i <= maxJump; i++ {
		if maxJump < i+nums[i] {
			maxJump = i + nums[i]
		}

		if maxJump >= n-1 {
			return true
		}
	}

	return false
}

func main() {
	nums1 := []int{2, 3, 1, 1, 4}
	fmt.Println(canJump(nums1)) // true

	nums2 := []int{3, 2, 1, 0, 4}
	fmt.Println(canJump(nums2)) // false

	nums3 := []int{0}
	fmt.Println(canJump(nums3)) // true

	nums4 := []int{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}
	fmt.Println(canJump(nums4)) // true
}
