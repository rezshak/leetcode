// https://leetcode.com/problems/robot-bounded-in-circle/

package main

import "fmt"

type Dir int

const (
	North Dir = iota
	South
	East
	West
)

// T: O(n), S: O(1)
func isRobotBounded(instructions string) bool {
	x, y := 0, 0
	dir := North
	for _, d := range instructions {
		switch d {
		case 'G':
			switch dir {
			case North:
				y++
			case South:
				y--
			case East:
				x++
			case West:
				x--
			}
		case 'L':
			switch dir {
			case North:
				dir = West
			case South:
				dir = East
			case East:
				dir = North
			case West:
				dir = South
			}
		case 'R':
			switch dir {
			case North:
				dir = East
			case South:
				dir = West
			case East:
				dir = South
			case West:
				dir = North
			}
		}
	}
	return (x == 0 && y == 0) || dir != North
}

func main() {
	instructions1 := "GGLLGG"
	instructions2 := "GG"
	instructions3 := "GL"
	fmt.Println(isRobotBounded(instructions1)) // true
	fmt.Println(isRobotBounded(instructions2)) // false
	fmt.Println(isRobotBounded(instructions3)) // true
}
