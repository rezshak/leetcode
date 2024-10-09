// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(1)
func checkOnesSegment(s string) bool {
	n := len(s)
	for i := 0; i < n-1; i++ {
		curr, next := s[i], s[i+1]
		if curr == '0' && next == '0' {
			return false
		}
	}
	return true
}

func checkOnesSegmentBuiltin(s string) bool {
	return !strings.Contains(s, "01")
}

func main() {
	fmt.Println(checkOnesSegment("1001"))        // false
	fmt.Println(checkOnesSegmentBuiltin("1001")) // false
	fmt.Println(checkOnesSegment("110"))         // true
	fmt.Println(checkOnesSegment("10"))          // true
}
