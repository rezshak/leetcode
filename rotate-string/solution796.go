// https://leetcode.com/problems/rotate-string/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func rotateString(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}
	s2 := s + s
	return strings.Contains(s2, goal)
}

func main() {
	fmt.Println(rotateString("abcde", "cdeab")) // true
	fmt.Println(rotateString("abcde", "abced")) // false
}
