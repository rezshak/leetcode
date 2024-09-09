// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

package main

import (
	"fmt"
	"math"
)

const N = 3

// T: O(m), S: O(1)
func tictactoe(moves [][]int) string {
	n := len(moves)
	// Row, column, and diagonal sums
	rows := [N]int{}
	cols := [N]int{}
	diag := 0
	antiDiag := 0
	player := 1
	for i := range moves {
		row := moves[i][0]
		col := moves[i][1]
		rows[row] += player
		cols[col] += player
		if row == col {
			diag += player
		}
		if row+col == N-1 {
			antiDiag += player
		}
		if abs(rows[row]) == N || abs(cols[col]) == N || abs(diag) == N || abs(antiDiag) == N {
			if player == 1 {
				return "A"
			}
			return "B"
		}
		player *= -1
	}
	if n == N*N {
		return "Draw"
	}
	return "Pending"
}

func abs(val int) int {
	return int(math.Abs(float64(val)))
}

func main() {
	var moves1 = [][]int{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}
	var moves2 = [][]int{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}
	fmt.Println(tictactoe(moves1)) // A
	fmt.Println(tictactoe(moves2)) // B
}
