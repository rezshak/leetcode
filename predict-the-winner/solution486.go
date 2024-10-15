// https://leetcode.com/problems/predict-the-winner/

package main

import (
	"fmt"
)

// T: (O(n^2)), S: (O(n^2))
func predictTheWinner(nums []int) bool {
	memo := make(map[string]int)
	return turn(nums, 0, len(nums)-1, true, memo) >= 0
}

func turn(nums []int, l, r int, player1 bool, memo map[string]int) int {
	key := fmt.Sprintf("%d,%d,%t", l, r, player1)
	if val, found := memo[key]; found {
		return val
	}
	if l > r {
		return 0
	}

	var result int
	if player1 {
		result = max(
			nums[l]+turn(nums, l+1, r, false, memo),
			nums[r]+turn(nums, l, r-1, false, memo))
	} else {
		result = min(
			-nums[l]+turn(nums, l+1, r, true, memo),
			-nums[r]+turn(nums, l, r-1, true, memo))
	}

	memo[key] = result
	return result
}

func main() {
	nums1 := []int{1, 5, 2}
	nums2 := []int{1, 5, 233, 7}
	fmt.Println(predictTheWinner(nums1)) // false
	fmt.Println(predictTheWinner(nums2)) // true
}
