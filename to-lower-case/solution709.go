// https://leetcode.com/problems/to-lower-case/

package main

import (
	"fmt"
	"strings"
)

const DIFF = 'a' - 'A' // 32
const UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
const LOWER = "abcdefghijklmnopqrstuvwxyz"

var MAP = make(map[rune]rune)

func init() {
	for i := 0; i < 26; i++ {
		MAP[rune(UPPER[i])] = rune(LOWER[i])
	}
}

// T: O(n), S: O(n)
func toLowerCase(s string) string {
	var sb strings.Builder
	for _, ch := range s {
		if ch >= 'A' && ch <= 'Z' {
			sb.WriteRune(ch + DIFF)
		} else {
			sb.WriteRune(ch)
		}
	}
	return sb.String()
}

// T: O(n), S: O(n)
func toLowerCaseMap(s string) string {
	var sb strings.Builder
	for _, ch := range s {
		if lower, ok := MAP[ch]; ok {
			sb.WriteRune(lower)
		} else {
			sb.WriteRune(ch)
		}
	}
	return sb.String()
}

func main() {
	s1 := "Hello"
	s2 := "here"
	s3 := "LOVELY"
	fmt.Println(toLowerCase(s1))    // hello
	fmt.Println(toLowerCaseMap(s1)) // hello
	fmt.Println(toLowerCase(s2))    // here
	fmt.Println(toLowerCaseMap(s2)) // here
	fmt.Println(toLowerCase(s3))    // lovely
	fmt.Println(toLowerCaseMap(s3)) // lovely
}
