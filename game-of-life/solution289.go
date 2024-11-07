// https://leetcode.com/problems/game-of-life/

package main

import (
	"fmt"
)

// T: O(mn), S: O(mn)
func gameOfLife(board [][]int) {
	rows, cols := len(board), len(board[0])
	newBoard := make([][]bool, rows)
	for i := range newBoard {
		newBoard[i] = make([]bool, cols)
		for j := range newBoard[i] {
			newBoard[i][j] = board[i][j] == 1
		}
	}
	for row := 0; row < rows; row++ {
		for col := 0; col < cols; col++ {
			top := max(0, row-1)
			bottom := min(rows-1, row+1)
			left := max(0, col-1)
			right := min(cols-1, col+1)
			liveNeighbors := 0

			for r := top; r <= bottom; r++ {
				for c := left; c <= right; c++ {
					if !(r == row && c == col) && newBoard[r][c] {
						liveNeighbors++
					}
				}
			}

			if liveNeighbors < 2 || liveNeighbors > 3 {
				board[row][col] = 0
			} else if liveNeighbors == 3 {
				board[row][col] = 1
			}
		}
	}
}

// T: O(mn), S: O(1)
func gameOfLifeOpt(board [][]int) {
	rows, cols := len(board), len(board[0])
	for row := 0; row < rows; row++ {
		for col := 0; col < cols; col++ {
			liveNeighbors := 0
			top := max(0, row-1)
			bottom := min(rows-1, row+1)
			left := max(0, col-1)
			right := min(cols-1, col+1)
			for r := top; r <= bottom; r++ {
				for c := left; c <= right; c++ {
					if !(r == row && c == col) && abs(board[r][c]) == 1 {
						liveNeighbors++
					}
				}
			}
			if board[row][col] == 1 {
				if liveNeighbors < 2 || liveNeighbors > 3 {
					board[row][col] = -1 // Alive to dead
				}
			} else {
				if liveNeighbors == 3 {
					board[row][col] = 2 // Dead to alive
				}
			}
		}
	}
	// Second pass: convert the transitional states to final states
	for row := 0; row < rows; row++ {
		for col := 0; col < cols; col++ {
			if board[row][col] > 0 {
				board[row][col] = 1
			} else {
				board[row][col] = 0
			}
		}
	}
}

// Utility functions for Go
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func main() {
	board1 := [][]int{
		{0, 1, 0},
		{0, 0, 1},
		{1, 1, 1},
		{0, 0, 0},
	}
	gameOfLife(board1)
	fmt.Println(board1) // [[0 0 0] [1 0 1] [0 1 1] [0 1 0]]

	board2 := [][]int{
		{1, 1},
		{1, 0},
	}
	gameOfLife(board2)
	fmt.Println(board2) // [[1 1] [1 1]]

	board3 := [][]int{
		{0, 1, 0},
		{0, 0, 1},
		{1, 1, 1},
		{0, 0, 0},
	}
	gameOfLifeOpt(board3)
	fmt.Println(board3) // [[0 0 0] [1 0 1] [0 1 1] [0 1 0]]

	board4 := [][]int{
		{1, 1},
		{1, 0},
	}
	gameOfLifeOpt(board4)
	fmt.Println(board4) // [[1 1] [1 1]]
}
