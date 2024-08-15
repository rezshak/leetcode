package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func judgeCircle(moves string) bool {
	position := []int{0, 0} // x, y
	for _, mv := range moves {
		switch mv {
		case 'U':
			position[0]--
		case 'D':
			position[0]++
		case 'R':
			position[1]++
		case 'L':
			position[1]--
		}
	}
	return position[0] == 0 && position[1] == 0
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
