// https://leetcode.com/problems/spiral-matrix/

package main

import (
	"fmt"
)

// T: O(m*n), S: O(1)
func spiralOrder(matrix [][]int) []int {
	rows := len(matrix)
	cols := len(matrix[0])
	top, bottom := 0, rows-1
	left, right := 0, cols-1
	result := []int{}

	for left <= right && top <= bottom {
		// Traverse left -> right
		for col := left; col <= right; col++ {
			result = append(result, matrix[top][col])
		}
		top++
		// Traverse top -> bottom
		for row := top; row <= bottom; row++ {
			result = append(result, matrix[row][right])
		}
		right--
		if top <= bottom {
			// Traverse right -> left
			for col := right; col >= left; col-- {
				result = append(result, matrix[bottom][col])
			}
			bottom--
		}
		if left <= right {
			// Traverse bottom -> top
			for row := bottom; row >= top; row-- {
				result = append(result, matrix[row][left])
			}
			left++
		}
	}

	return result
}

func main() {
	matrix1 := [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
	matrix2 := [][]int{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}
	matrix3 := [][]int{{1, 2, 3, 4}}
	fmt.Println(spiralOrder(matrix1)) // [1, 2, 3, 6, 9, 8, 7, 4, 5]
	fmt.Println(spiralOrder(matrix2)) // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
	fmt.Println(spiralOrder(matrix3)) // [1, 2, 3, 4]
}
