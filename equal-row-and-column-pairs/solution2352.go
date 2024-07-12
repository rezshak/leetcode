// https://leetcode.com/problems/equal-row-and-column-pairs/

package main

import (
	"encoding/json"
	"fmt"
)

// T: O(n^2), S: O(n^2)
func equalPairs(grid [][]int) int {
	n, pairsCount := len(grid), 0
	rowsMap := make(map[string]int)
	for _, row := range grid {
		key := getKey(row)
		rowsMap[key]++
	}
	for col := 0; col < n; col++ {
		colArr := make([]int, n)
		for row := 0; row < n; row++ {
			colArr[row] = grid[row][col]
		}
		key := getKey(colArr)
		if count, ok := rowsMap[key]; ok {
			pairsCount += count
		}
	}
	return pairsCount
}

func getKey(arr []int) string {
	s, _ := json.Marshal(arr)
	return string(s)
}

func main() {
	var grid1 = [][]int{
		{3, 2, 1},
		{1, 7, 6},
		{2, 7, 7},
	}
	var grid2 = [][]int{
		{3, 1, 2, 2},
		{1, 4, 4, 5},
		{2, 4, 2, 2},
		{2, 4, 2, 2},
	}
	fmt.Println(equalPairs(grid1)) // 1
	fmt.Println(equalPairs(grid2)) // 3
}
