// https://leetcode.com/problems/baseball-game/

package main

import (
	"fmt"
	"strconv"
)

// T: O(n), S: O(n)
func calPoints(ops []string) int {
	var stack []int
	for _, op := range ops {
		switch op {
		case "C":
			if len(stack) > 0 {
				stack = stack[:len(stack)-1]
			}
		case "D":
			if len(stack) > 0 {
				newScore := 2 * stack[len(stack)-1]
				stack = append(stack, newScore)
			}
		case "+":
			if len(stack) > 1 {
				newScore := stack[len(stack)-1] + stack[len(stack)-2]
				stack = append(stack, newScore)
			}
		default:
			score, err := strconv.Atoi(op)
			if err == nil {
				stack = append(stack, score)
			}
		}
	}
	ans := 0
	for _, score := range stack {
		ans += score
	}
	return ans
}

func main() {
	var ops1 = []string{"5", "2", "C", "D", "+"}
	var ops2 = []string{"5", "-2", "4", "C", "D", "9", "+", "+"}
	var ops3 = []string{"1", "C"}
	fmt.Println(calPoints(ops1)) // 30
	fmt.Println(calPoints(ops2)) // 27
	fmt.Println(calPoints(ops3)) // 0
}
