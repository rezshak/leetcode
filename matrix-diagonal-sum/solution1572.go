// https://leetcode.com/problems/matrix-diagonal-sum/

package main

import "fmt"

// T: O(n), S: O(1)
func diagonalSum(mat [][]int) int {
	n := len(mat)
	diagSum, antiDiagSum := 0, 0
	for i := range mat {
		diagSum += mat[i][i]
		if i != n-1-i {
			antiDiagSum += mat[i][n-1-i]
		}
	}
	return antiDiagSum + diagSum
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
