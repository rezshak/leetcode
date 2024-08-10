package main

import (
	"fmt"
	"strings"
)

const DIFF = 'a' - 'A' // 32
const UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
const LOWER = "abcdefghijklmnopqrstuvwxyz"

// T: O(n), S: O(1)
func toLowerCase(s string) string {
	b := []byte(s)
	for i := 0; i < len(b); i++ {
		if b[i] >= 'A' && b[i] <= 'Z' {
			b[i] += DIFF
		}
	}
	return string(b)
}

// T: O(n), S: O(n)
func toLowerCaseDict(s string) string {
	var sb strings.Builder
	for _, ch := range s {
		idx := strings.IndexRune(UPPER, ch)
		if idx != -1 {
			sb.WriteRune(rune(LOWER[idx]))
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
	fmt.Println(toLowerCase(s1))     // hello
	fmt.Println(toLowerCase(s2))     // here
	fmt.Println(toLowerCase(s3))     // lovely
	fmt.Println(toLowerCaseDict(s1)) // hello
	fmt.Println(toLowerCaseDict(s2)) // here
	fmt.Println(toLowerCaseDict(s3)) // lovely
}
