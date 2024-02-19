// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

package main

import "fmt"

// T: O(n), S: O(1)
func findLengthOfLCIS(nums []int) int {
	n := len(nums)
	count := 0
	ans := 0
	for i := 0; i < n-1; i++ {
		if nums[i] < nums[i+1] {
			count++
			ans = max(ans, count)
		} else {
			count = 0
		}
	}
	return ans + 1
}

func main() {
	nums1 := []int{1, 3, 5, 4, 7} // 3
	nums2 := []int{2, 2, 2, 2, 2} // 1
	fmt.Println(findLengthOfLCIS(nums1))
	fmt.Println(findLengthOfLCIS(nums2))
}
