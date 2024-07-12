// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

package main

import "fmt"

// T: O(n), S: O(1)
func finalValueAfterOperations(operations []string) int {
	x := 0
	for _, op := range operations {
		switch op {
		case "X++", "++X":
			x++
		case "X--", "--X":
			x--
		}
	}
	return x
}

func main() {
	ops1 := []string{"--X", "X++", "X++"}
	ops2 := []string{"++X", "++X", "X++"}
	fmt.Println(finalValueAfterOperations(ops1)) // 1
	fmt.Println(finalValueAfterOperations(ops2)) // 3
}
