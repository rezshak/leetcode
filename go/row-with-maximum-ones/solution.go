// https://leetcode.com/problems/row-with-maximum-ones/

package main

import "fmt"

// T: O(mn), S: O(1)
func rowAndMaximumOnes(mat [][]int) []int {
	maxOnesIdx := 0
	maxOnesCount := 0
	for i, row := range mat {
		onesCount := getOnesCount(row)
		if onesCount > maxOnesCount {
			maxOnesCount = onesCount
			maxOnesIdx = i
		}
	}
	return []int{maxOnesIdx, maxOnesCount}
}

func getOnesCount(arr []int) int {
	count := 0
	for _, n := range arr {
		if n == 1 {
			count++
		}
	}
	return count
}

func main() {
	mat1 := [][]int{
		{1, 0},
		{0, 1},
	}
	fmt.Println(rowAndMaximumOnes(mat1)) // [0,1]
	mat2 := [][]int{
		{0, 0, 0},
		{0, 1, 1},
	}
	fmt.Println(rowAndMaximumOnes(mat2)) // [1,2]
}
