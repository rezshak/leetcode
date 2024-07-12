// https://leetcode.com/problems/convert-1d-array-into-2d-array/

package main

import "fmt"

// T: O(mn), S: (mn)
func construct2DArray(original []int, m int, n int) [][]int {
	if len(original) != m*n {
		return [][]int{}
	}
	result := make([][]int, m)
	for i := range result {
		result[i] = make([]int, n)
	}
	for i, k := 0, 0; i < m && k < len(original); i++ {
		for j := 0; j < n; j++ {
			result[i][j] = original[k]
			k++
		}
	}
	return result
}

func main() {
	nums1 := []int{1, 2, 3, 4}
	nums2 := []int{1, 2, 3}
	nums3 := []int{1, 2}
	fmt.Println(construct2DArray(nums1, 2, 2)) // [[1 2] [3 4]]
	fmt.Println(construct2DArray(nums2, 1, 3)) // [[1 2 3]]
	fmt.Println(construct2DArray(nums3, 1, 1)) // []
}
