// https://leetcode.com/problems/running-sum-of-1d-array/

package main

import "fmt"

// T: O(n), S: O(n)
func runningSum(nums []int) []int {
	result := make([]int, len(nums))
	runningSum := 0
	for i, n := range nums {
		runningSum += n
		result[i] = runningSum
	}
	return result
}

func main() {
	var nums1 = []int{1, 2, 3, 4}
	fmt.Println(runningSum(nums1)) // 1,3,6,10
	var nums2 = []int{1, 1, 1, 1, 1}
	fmt.Println(runningSum(nums2)) // 1,2,3,4,5
}
