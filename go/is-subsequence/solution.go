// https://leetcode.com/problems/is-subsequence/

package main

import "fmt"

// T: O(n), S: O(1)
func isSubsequence(s string, t string) bool {
	sLen, tLen := len(s), len(t)
	sIdx, tIdx := 0, 0
	for sIdx < sLen && tIdx < tLen {
		if s[sIdx] == t[tIdx] {
			sIdx++
		}
		tIdx++
	}
	return sIdx == sLen
}

func main() {
	s := "abc"
	t := "ahbgdc"
	fmt.Println(isSubsequence(s, t)) // true
	s = "axc"
	t = "ahbgdc"
	fmt.Println(isSubsequence(s, t)) // false
	s = ""
	t = "ahbgdc"
	fmt.Println(isSubsequence(s, t)) // true
}
