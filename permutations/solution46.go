// https://leetcode.com/problems/permutations/

package main

import (
	"fmt"
)

// T: O(n*n!), S: O(n*n!)
func permute(nums []int) [][]int {
	var result [][]int
	var curr []int
	backtrack(nums, &result, curr)
	return result
}

func backtrack(nums []int, result *[][]int, curr []int) {
	if len(curr) == len(nums) {
		perm := make([]int, len(curr))
		copy(perm, curr)
		*result = append(*result, perm)
		return
	}
	for _, num := range nums {
		if !contains(curr, num) {
			curr = append(curr, num)
			backtrack(nums, result, curr)
			curr = curr[:len(curr)-1]
		}
	}
}

func contains(slice []int, num int) bool {
	for _, v := range slice {
		if v == num {
			return true
		}
	}
	return false
}

// T: O(n*n!), S: O(n*n!)
func permuteIterative(nums []int) [][]int {
	result := [][]int{{}}
	for _, num := range nums {
		var curr [][]int
		for _, perm := range result {
			for i := 0; i <= len(perm); i++ {
				newPerm := append([]int{}, perm[:i]...)
				newPerm = append(newPerm, num)
				newPerm = append(newPerm, perm[i:]...)
				curr = append(curr, newPerm)
			}
		}
		result = curr
	}
	return result
}

func main() {
	nums1 := []int{1, 2, 3}
	nums2 := []int{0, 1}
	nums3 := []int{1}
	fmt.Println(permute(nums1))          // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	fmt.Println(permute(nums2))          // [[0,1],[1,0]]
	fmt.Println(permute(nums3))          // [[1]]
	fmt.Println(permuteIterative(nums1)) // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	fmt.Println(permuteIterative(nums2)) // [[0,1],[1,0]]
	fmt.Println(permuteIterative(nums3)) // [[1]]
}
