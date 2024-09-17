// https://leetcode.com/problems/longest-consecutive-sequence/

package main

import "fmt"

// T: O(n), S: O(n)
func longestConsecutive(nums []int) int {
	set := make(map[int]bool)
	for _, n := range nums {
		set[n] = true
	}
	longest := 0
	for _, n := range nums {
		if !set[n-1] {
			count := 1
			for set[n+1] {
				count++
				n++
			}
			longest = max(longest, count)
		}
	}
	return longest
}

func main() {
	var nums1 = []int{100, 4, 200, 1, 3, 2}
	var nums2 = []int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}
	fmt.Println(longestConsecutive(nums1)) // 4
	fmt.Println(longestConsecutive(nums2)) // 9
}
