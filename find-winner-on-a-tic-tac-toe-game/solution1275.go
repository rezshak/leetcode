// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

package main

import (
	"fmt"
)

const (
	N       = 3
	PLAYER1 = 1
	PLAYER2 = -1
)

// T: O(m), S: O(1)
func tictactoe(moves [][]int) string {
	board := make([][]int, N)
	for i := range board {
		board[i] = make([]int, N)
	}
	player1Turn := true
	for _, mv := range moves {
		x, y := mv[0], mv[1]
		if player1Turn {
			board[x][y] = PLAYER1
			player1Turn = false
		} else {
			board[x][y] = PLAYER2
			player1Turn = true
		}
	}
	// Check if a row is winner
	for r := 0; r < N; r++ {
		rowSum := 0
		for c := 0; c < N; c++ {
			rowSum += board[r][c]
		}
		if rowSum == N {
			return "A"
		} else if rowSum == -N {
			return "B"
		}
	}
	// Check if a col is winner
	for c := 0; c < N; c++ {
		colSum := 0
		for r := 0; r < N; r++ {
			colSum += board[r][c]
		}
		if colSum == N {
			return "A"
		} else if colSum == -N {
			return "B"
		}
	}
	// Check left-right and right-left diagonals
	lrDiagSum, rlDiagSum := 0, 0
	for i := 0; i < N; i++ {
		lrDiagSum += board[i][i]
		rlDiagSum += board[i][N-i-1]
	}
	if lrDiagSum == N || rlDiagSum == N {
		return "A"
	} else if lrDiagSum == -N || rlDiagSum == -N {
		return "B"
	}
	if len(moves) < N*N {
		return "Pending"
	}
	return "Draw"
}

func main() {
	moves1 := [][]int{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}
	moves2 := [][]int{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}
	fmt.Println(tictactoe(moves1)) // A
	fmt.Println(tictactoe(moves2)) // B
}
