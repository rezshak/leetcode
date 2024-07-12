// https://leetcode.com/problems/make-the-string-great/

package main

import (
	"fmt"
	"unicode"
)

// T: O(n), S: O(n)
func makeGood(s string) string {
	stack := make([]rune, 0)
	for _, ch := range s {
		if len(stack) != 0 && areSameCharsDiffCases(ch, stack[len(stack)-1]) {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, ch)
		}
	}
	return string(stack)
}

func areSameCharsDiffCases(ch1, ch2 rune) bool {
	if ch1 == ch2 {
		return false
	}
	if unicode.ToLower(ch1) != unicode.ToLower(ch2) {
		return false
	}
	return true
}

func main() {
	s1 := "leEeetcode"
	s2 := "abBAcC"
	s3 := "s"
	fmt.Println(makeGood(s1)) // "leetcode"
	fmt.Println(makeGood(s2)) // ""
	fmt.Println(makeGood(s3)) // "s"
}
