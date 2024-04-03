// https://leetcode.com/problems/find-the-highest-altitude/

package main

import "fmt"

// T: O(n), S: O(1)
func largestAltitude(gain []int) int {
	max, curr := 0, 0
	for _, val := range gain {
		curr += val
		if curr > max {
			max = curr
		}
	}
	return max
}

func main() {
	nums1 := []int{-5, 1, 5, 0, -7}
	nums2 := []int{-4, -3, -2, -1, 4, 3, 2}
	fmt.Println(largestAltitude(nums1)) // 1
	fmt.Println(largestAltitude(nums2)) // 0
}
