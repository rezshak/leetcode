// https://leetcode.com/problems/lucky-numbers-in-a-matrix/

package main

import (
	"fmt"
	"math"
)

// T: O(m*n), S: O(m+n)
func luckyNumbers(matrix [][]int) []int {
	m, n := len(matrix), len(matrix[0])
	rowsMin, colsMax := make([]int, m), make([]int, n)
	for r := 0; r < m; r++ {
		rowsMin[r] = math.MaxInt32
		for c := 0; c < n; c++ {
			rowsMin[r] = min(rowsMin[r], matrix[r][c])
		}
	}
	for c := 0; c < n; c++ {
		colsMax[c] = math.MinInt32
		for r := 0; r < m; r++ {
			colsMax[c] = max(colsMax[c], matrix[r][c])
		}
	}
	var result []int
	for r := 0; r < m; r++ {
		for c := 0; c < n; c++ {
			num := matrix[r][c]
			if num == rowsMin[r] && num == colsMax[c] {
				result = append(result, num)
			}
		}
	}
	return result
}

func main() {
	matrix := [][]int{
		{3, 7, 8},
		{9, 11, 13},
		{15, 16, 17},
	}
	luckyNumbers := luckyNumbers(matrix)
	fmt.Println(luckyNumbers) // [15]
}
