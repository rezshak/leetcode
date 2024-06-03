// https://leetcode.com/problems/two-sum/

package main

import "fmt"

// T: O(n), S: O(n)
func twoSum(nums []int, target int) []int {
	idxMap := make(map[int]int)
	for i, n := range nums {
		diff := target - n
		if idx, ok := idxMap[diff]; ok {
			return []int{idx, i}
		}
		idxMap[n] = i
	}
	return nil
}

func main() {
	nums1 := []int{2, 7, 11, 15}
	target1 := 9
	fmt.Println(twoSum(nums1, target1))
	nums2 := []int{3, 2, 4}
	target2 := 6
	fmt.Println(twoSum(nums2, target2))
	nums3 := []int{3, 3}
	target3 := 6
	fmt.Println(twoSum(nums3, target3))
}
