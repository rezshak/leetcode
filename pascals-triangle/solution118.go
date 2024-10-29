// https://leetcode.com/problems/pascals-triangle/

package main

import (
	"fmt"
)

// T: O(n^2), S: O(n^2)
func generate(numRows int) [][]int {
	var triangle [][]int
	if numRows == 0 {
		return triangle
	}
	triangle = append(triangle, []int{1})
	for r := 1; r < numRows; r++ {
		newRow := []int{1}
		prevRow := triangle[r-1]
		for c := 1; c < len(prevRow); c++ {
			num := prevRow[c-1] + prevRow[c]
			newRow = append(newRow, num)
		}
		newRow = append(newRow, 1)
		triangle = append(triangle, newRow)
	}
	return triangle
}

func main() {
	fmt.Println(generate(5)) // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
	fmt.Println(generate(1)) // [[1]]
}
