// https://leetcode.com/problems/missing-number/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func missingNumberSum(nums []int) int {
	n := len(nums)
	expectedSum := n * (n + 1) / 2
	actualSum := 0
	for _, num := range nums {
		actualSum += num
	}
	return expectedSum - actualSum
}

// T: O(n), S: O(1)
func missingNumberXor(nums []int) int {
	missing := len(nums)
	for i, num := range nums {
		missing ^= i ^ num
	}
	return missing
}

// T: O(n), S: O(n)
func missingNumberBitSet(nums []int) int {
	n := len(nums)
	if n == 0 {
		return 0
	}
	set := make([]bool, n+1)
	for _, num := range nums {
		set[num] = true
	}
	for i := 0; i <= n; i++ {
		if !set[i] {
			return i
		}
	}
	return -1
}

func main() {
	nums1 := []int{3, 0, 1}
	nums2 := []int{0, 1}
	nums3 := []int{9, 6, 4, 2, 3, 5, 7, 0, 1}

	fmt.Println(missingNumberSum(nums1))    // 2
	fmt.Println(missingNumberXor(nums1))    // 2
	fmt.Println(missingNumberBitSet(nums1)) // 2

	fmt.Println(missingNumberSum(nums2))    // 2
	fmt.Println(missingNumberXor(nums2))    // 2
	fmt.Println(missingNumberBitSet(nums2)) // 2

	fmt.Println(missingNumberSum(nums3))    // 8
	fmt.Println(missingNumberXor(nums3))    // 8
	fmt.Println(missingNumberBitSet(nums3)) // 8
}
