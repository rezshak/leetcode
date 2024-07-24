// https://leetcode.com/problems/find-the-array-concatenation-value/

package main

import (
	"fmt"
	"strconv"
)

// T: O(n), S: O(1)
func findTheArrayConcVal(nums []int) int64 {
	var ans int64
	for i, j := 0, len(nums)-1; i <= j; i, j = i+1, j-1 {
		var numStr string
		if i != j {
			numStr = strconv.Itoa(nums[i]) + strconv.Itoa(nums[j])
		} else {
			numStr = strconv.Itoa(nums[i])
		}
		num, _ := strconv.ParseInt(numStr, 10, 64)
		ans += num
	}
	return ans
}

func main() {
	nums1 := []int{7, 52, 2, 4}
	nums2 := []int{5, 14, 13, 8, 12}
	fmt.Println(findTheArrayConcVal(nums1)) // 596
	fmt.Println(findTheArrayConcVal(nums2)) // 673
}
