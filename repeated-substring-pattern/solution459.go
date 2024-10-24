// https://leetcode.com/problems/repeated-substring-pattern/

package main

import (
	"fmt"
	"strings"
)

// T: O(n^2), S: O(n)
func repeatedSubstringPattern(s string) bool {
	n := len(s)
	for i := 1; i <= n/2; i++ {
		if n%i == 0 {
			substring := s[:i]
			sb := strings.Builder{}
			for j := 0; j < n/i; j++ {
				sb.WriteString(substring)
			}
			if sb.String() == s {
				return true
			}
		}
	}
	return false
}

// T: O(n), S: O(n)
func repeatedSubstringPatternOpt(s string) bool {
	t := s + s
	sub := t[1 : len(t)-1]
	return strings.Contains(sub, s)
}

func main() {
	fmt.Println(repeatedSubstringPattern("abab"))            // true
	fmt.Println(repeatedSubstringPattern("aba"))             // false
	fmt.Println(repeatedSubstringPattern("abcabcabcabc"))    // true
	fmt.Println(repeatedSubstringPatternOpt("abcabcabcabc")) // true
}
