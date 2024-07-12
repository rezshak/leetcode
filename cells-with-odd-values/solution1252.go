// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

package main

import "fmt"

// T: O(mn), S: O(mn)
func oddCells(m int, n int, indices [][]int) int {
	arr := make([][]int, m)
	for i := 0; i < m; i++ {
		arr[i] = make([]int, n)
	}
	for r := 0; r < len(indices); r++ {
		row := indices[r][0]
		col := indices[r][1]
		incrementRow(arr, row)
		incrementCol(arr, col)
	}
	count := 0
	for _, row := range arr {
		for _, cell := range row {
			if cell%2 == 1 {
				count++
			}
		}
	}
	return count
}

func incrementRow(arr [][]int, row int) {
	for c := range arr[row] {
		arr[row][c]++
	}
}

func incrementCol(arr [][]int, col int) {
	for r := range arr {
		arr[r][col]++
	}
}

func main() {
	indices1 := [][]int{
		{0, 1},
		{1, 1},
	}
	fmt.Println(oddCells(2, 3, indices1)) // 6
	indices2 := [][]int{
		{1, 1},
		{0, 0},
	}
	fmt.Println(oddCells(2, 2, indices2)) // 0
}
