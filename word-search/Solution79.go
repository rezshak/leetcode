package main

import "fmt"

// T: O(m * n * 4^L), S: O(L)
func exist(board [][]byte, word string) bool {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			if backtrack(board, word, i, j, 0) {
				return true
			}
		}
	}
	return false
}

// T: O(4^L), S: O(L)
func backtrack(board [][]byte, word string, i, j, idx int) bool {
	if idx == len(word) {
		return true
	}
	if i < 0 || i >= len(board) || j < 0 || j >= len(board[i]) || board[i][j] != word[idx] {
		return false
	}

	temp := board[i][j]
	board[i][j] = '#'

	found := backtrack(board, word, i+1, j, idx+1) ||
		backtrack(board, word, i-1, j, idx+1) ||
		backtrack(board, word, i, j+1, idx+1) ||
		backtrack(board, word, i, j-1, idx+1)

	board[i][j] = temp

	return found
}

func main() {
	board1 := [][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}
	word1 := "ABCCED"
	fmt.Println(exist(board1, word1)) // true

	board2 := [][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}
	word2 := "SEE"
	fmt.Println(exist(board2, word2)) // true

	board3 := [][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}
	word3 := "ABCB"
	fmt.Println(exist(board3, word3)) // false
}
