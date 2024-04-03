// https://leetcode.com/problems/unique-number-of-occurrences/

package main

import "fmt"

// T: O(n), S: O(n)
func uniqueOccurrences(arr []int) bool {
	freqs := make(map[int]int)
	for _, n := range arr {
		freqs[n]++
	}
	counts := make(map[int]bool)
	for _, val := range freqs {
		if counts[val] {
			return false
		}
		counts[val] = true
	}
	return true
}

func main() {
	nums1 := []int{1, 2, 2, 1, 1, 3}
	nums2 := []int{1, 2}
	nums3 := []int{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}
	fmt.Println(uniqueOccurrences(nums1)) // true
	fmt.Println(uniqueOccurrences(nums2)) // false
	fmt.Println(uniqueOccurrences(nums3)) // true
}
