// https://leetcode.com/problems/increasing-triplet-subsequence/

package main

import (
	"fmt"
	"math"
)

// T: O(n), S: O(1)
func increasingTriplet(nums []int) bool {
	a, b := math.MaxInt32, math.MaxInt32
	for _, n := range nums {
		if n <= a {
			a = n
		} else if n > a && n <= b {
			b = n
		} else if n > b {
			return true
		}
	}

	return false
}

func main() {
	nums1 := []int{1, 2, 3, 4, 5}
	nums2 := []int{5, 4, 3, 2, 1}
	nums3 := []int{2, 1, 5, 0, 4, 6}
	nums4 := []int{2, 4, -2, -3}
	fmt.Println(increasingTriplet(nums1)) // true
	fmt.Println(increasingTriplet(nums2)) // false
	fmt.Println(increasingTriplet(nums3)) // true
	fmt.Println(increasingTriplet(nums4)) // false
}
