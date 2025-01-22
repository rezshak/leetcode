// https://leetcode.com/problems/two-sum/

package main

import "fmt"

// T: O(n), S: O(n)
func twoSum(nums []int, target int) []int {
	indices := make(map[int]int)
	for i, n := range nums {
		diff := target - n
		if idx, ok := indices[diff]; ok {
			return []int{idx, i}
		}
		indices[n] = i
	}
	return nil
}

func main() {
	nums1 := []int{2, 7, 11, 15}
	nums2 := []int{3, 2, 4}
	nums3 := []int{3, 3}
	fmt.Println(twoSum(nums1, 9)) // [0, 1]
	fmt.Println(twoSum(nums2, 6)) // [1, 2]
	fmt.Println(twoSum(nums3, 6)) // [0, 1]
}
