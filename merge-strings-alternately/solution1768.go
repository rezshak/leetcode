// https://leetcode.com/problems/merge-strings-alternately/

package main

import (
	"fmt"
	"strings"
)

// T: O(n+m), S: O(n+m)
func mergeAlternately(word1 string, word2 string) string {
	n1, n2 := len(word1), len(word2)
	p1, p2 := 0, 0
	var sb strings.Builder
	for p1 < n1 || p2 < n2 {
		if p1 < n1 {
			sb.WriteByte(word1[p1])
			p1++
		}
		if p2 < n2 {
			sb.WriteByte(word2[p2])
			p2++
		}
	}
	return sb.String()
}

func main() {
	w1 := "abc"
	w2 := "pqr"
	fmt.Println(mergeAlternately(w1, w2)) // "apbqcr"
	w1 = "ab"
	w2 = "pqrs"
	fmt.Println(mergeAlternately(w1, w2)) // "apbqrs"
	w1 = "abcd"
	w2 = "pq"
	fmt.Println(mergeAlternately(w1, w2)) // "apbqcd"
}
