// https://leetcode.com/problems/single-number/

package main

import "fmt"

// T: O(n), S: O(1)
func singleNumber(nums []int) int {
	res := 0
	for _, n := range nums {
		res ^= n
	}
	return res
}

func main() {
	var nums1 = []int{2, 2, 1}
	var nums2 = []int{4, 1, 2, 1, 2}
	var nums3 = []int{1}
	fmt.Println(singleNumber(nums1)) // 1
	fmt.Println(singleNumber(nums2)) // 4
	fmt.Println(singleNumber(nums3)) // 1
}
