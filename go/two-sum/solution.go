// https://leetcode.com/problems/two-sum/

package main

import "fmt"

// T: O(n), S: O(n)
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for idx, num := range nums {
		diff := target - num
		if val, ok := m[diff]; ok {
			return []int{val, idx}
		}
		m[num] = idx
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
