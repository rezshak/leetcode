// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

package main

import "fmt"

func findDisappearedNumbers(nums []int) []int {
	set := make(map[int]bool)
	for _, num := range nums {
		set[num] = true
	}
	n := len(nums)
	var result []int
	for i := 1; i <= n; i++ {
		if !set[i] {
			result = append(result, i)
		}
	}
	return result
}

func main() {
	nums1 := []int{4, 3, 2, 7, 8, 2, 3, 1}
	nums2 := []int{1, 1}
	fmt.Println(findDisappearedNumbers(nums1)) // [5, 6]
	fmt.Println(findDisappearedNumbers(nums2)) // [2]
}
