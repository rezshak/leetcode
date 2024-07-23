// https://leetcode.com/problems/apply-operations-to-an-array/

package main

import "fmt"

// T: O(n), S: O(1)
func applyOperations(nums []int) []int {
	n := len(nums)
	for i := 0; i < n-1; i++ {
		if nums[i] == nums[i+1] {
			nums[i] *= 2
			nums[i+1] = 0
		}
	}
	j := 0
	for _, n := range nums {
		if n != 0 {
			nums[j] = n
			j++
		}
	}
	for j < n {
		nums[j] = 0
		j++
	}
	return nums
}

func main() {
	var nums1 = []int{1, 2, 2, 1, 1, 0}
	var nums2 = []int{0, 1}
	fmt.Println(applyOperations(nums1)) // [1,4,2,0,0,0]
	fmt.Println(applyOperations(nums2)) // [1,0]
}
