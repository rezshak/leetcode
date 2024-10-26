package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func judgeCircle(moves string) bool {
	board := []int{0, 0} // x, y
	for _, mv := range moves {
		switch mv {
		case 'U':
			board[0]--
		case 'D':
			board[0]++
		case 'R':
			board[1]++
		case 'L':
			board[1]--
		}
	}
	return board[0] == 0 && board[1] == 0
}

func main() {
	moves1 := "UD"
	moves2 := "LL"
	moves3 := "UDLR"
	moves4 := "UUDDLLRR"
	fmt.Println(judgeCircle(moves1)) // true
	fmt.Println(judgeCircle(moves2)) // false
	fmt.Println(judgeCircle(moves3)) // true
	fmt.Println(judgeCircle(moves4)) // true
}
