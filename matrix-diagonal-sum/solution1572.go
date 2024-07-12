// https://leetcode.com/problems/matrix-diagonal-sum/

package main

import "fmt"

// T: O(n), S: O(1)
func diagonalSum(mat [][]int) int {
	rows, cols := len(mat), len(mat[0])
	sum := 0
	for r, c := 0, 0; r < rows && c < cols; r, c = r+1, c+1 {
		sum += mat[r][c]
	}
	for r, c := 0, cols-1; r < rows && c >= 0; r, c = r+1, c-1 {
		sum += mat[r][c]
	}
	if rows%2 == 1 {
		sum -= mat[rows/2][cols/2]
	}
	return sum
}

func main() {
	var mat1 = [][]int{
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
	}
	fmt.Println(diagonalSum(mat1)) // 25
	var mat2 = [][]int{
		{1, 1, 1, 1},
		{1, 1, 1, 1},
		{1, 1, 1, 1},
		{1, 1, 1, 1},
	}
	fmt.Println(diagonalSum(mat2)) // 8
}
