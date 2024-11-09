// https://leetcode.com/problems/set-matrix-zeroes/

package main

import (
	"fmt"
)

// T: O(m*n), S: (m+n)
func setZeroes(matrix [][]int) {
	rows := len(matrix)
	cols := len(matrix[0])
	rowsToSet := make([]bool, rows)
	colsToSet := make([]bool, cols)
	for row := 0; row < rows; row++ {
		for col := 0; col < cols; col++ {
			if matrix[row][col] == 0 {
				rowsToSet[row] = true
				colsToSet[col] = true
			}
		}
	}
	for r := 0; r < rows; r++ {
		if rowsToSet[r] {
			resetRow(matrix, r)
		}
	}
	for c := 0; c < cols; c++ {
		if colsToSet[c] {
			resetCol(matrix, c)
		}
	}
}

// T: O(m*n), S: O(1)
func setZeroesOpt(matrix [][]int) {
	rows := len(matrix)
	cols := len(matrix[0])
	firstRowHasZero := false
	firstColHasZero := false
	for col := 0; col < cols; col++ {
		if matrix[0][col] == 0 {
			firstRowHasZero = true
			break
		}
	}
	for row := 0; row < rows; row++ {
		if matrix[row][0] == 0 {
			firstColHasZero = true
			break
		}
	}
	for row := 1; row < rows; row++ {
		for col := 1; col < cols; col++ {
			if matrix[row][col] == 0 {
				matrix[row][0] = 0
				matrix[0][col] = 0
			}
		}
	}
	for row := 1; row < rows; row++ {
		if matrix[row][0] == 0 {
			resetRow(matrix, row)
		}
	}
	for col := 1; col < cols; col++ {
		if matrix[0][col] == 0 {
			resetCol(matrix, col)
		}
	}
	if firstRowHasZero {
		resetRow(matrix, 0)
	}
	if firstColHasZero {
		resetCol(matrix, 0)
	}
}

func resetRow(matrix [][]int, rowIdx int) {
	cols := len(matrix[0])
	for c := 0; c < cols; c++ {
		matrix[rowIdx][c] = 0
	}
}

func resetCol(matrix [][]int, colIdx int) {
	rows := len(matrix)
	for r := 0; r < rows; r++ {
		matrix[r][colIdx] = 0
	}
}

func main() {
	matrix1 := [][]int{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}
	matrix2 := [][]int{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}
	setZeroes(matrix1)
	setZeroesOpt(matrix2)
	fmt.Println(matrix1) // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
	fmt.Println(matrix2) // [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]
}
