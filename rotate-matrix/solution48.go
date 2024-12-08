// https://leetcode.com/problems/rotate-image/

package main

import "fmt"

// T: O(n), S: O(1)
func rotate(matrix [][]int) {
	n := len(matrix)

	// Transpose the matrix
	for i := 0; i < n; i++ {
		for j := i; j < n; j++ {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}

	fmt.Println("Transposed:")
	printMatrix(matrix)

	// Reverse each row
	for i := 0; i < n; i++ {
		for j := 0; j < n/2; j++ {
			matrix[i][j], matrix[i][n-1-j] = matrix[i][n-1-j], matrix[i][j]
		}
	}
}

// T: O(n^2), S: O(1)
func rotateBrute(matrix [][]int) {
	n := len(matrix)
	orig := make([][]int, n)
	for i := range matrix {
		orig[i] = append([]int(nil), matrix[i]...)
	}
	for r := 0; r < n; r++ {
		nums := orig[r]
		copyRowToCol(matrix, nums, n-r-1)
	}
}

func copyRowToCol(matrix [][]int, nums []int, col int) {
	n := len(matrix)
	for i := 0; i < n; i++ {
		matrix[i][col] = nums[i]
	}
}

func printMatrix(matrix [][]int) {
	for _, row := range matrix {
		for _, num := range row {
			fmt.Print(num, " ")
		}
		fmt.Println()
	}
}

func main() {

	matrix1 := [][]int{
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
	}
	fmt.Println("Original:")
	printMatrix(matrix1)
	rotate(matrix1)
	fmt.Println("Rotated:")
	printMatrix(matrix1)

	matrix2 := [][]int{
		{5, 1, 9, 11},
		{2, 4, 8, 10},
		{13, 3, 6, 7},
		{15, 14, 12, 16},
	}
	fmt.Println("Original:")
	printMatrix(matrix2)
	rotate(matrix2)
	fmt.Println("Rotated:")
	printMatrix(matrix2)

	matrix3 := [][]int{
		{1, 2},
		{3, 4},
	}
	fmt.Println("Original:")
	printMatrix(matrix3)
	rotate(matrix3)
	fmt.Println("Rotated:")
	printMatrix(matrix3)
}
