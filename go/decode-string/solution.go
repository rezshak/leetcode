// https://leetcode.com/problems/decode-string/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O
func decodeString(s string) string {
	countStack := []int{}
	stringStack := []string{}
	currentString := ""
	k := 0
	for _, ch := range s {
		if ch >= '0' && ch <= '9' {
			k = k*10 + int(ch-'0')
		} else if ch == '[' {
			countStack = append(countStack, k)
			stringStack = append(stringStack, currentString)
			currentString = ""
			k = 0
		} else if ch == ']' {
			count := countStack[len(countStack)-1]
			countStack = countStack[:len(countStack)-1]
			decodedString := stringStack[len(stringStack)-1]
			stringStack = stringStack[:len(stringStack)-1]
			currentString = decodedString + strings.Repeat(currentString, count)
		} else {
			currentString += string(ch)
		}
	}
	return currentString
}

func main() {
	s1 := "3[a]2[bc]"
	s2 := "3[a2[c]]"
	s3 := "2[abc]3[cd]ef"
	fmt.Println(decodeString(s1)) // aaabcbc
	fmt.Println(decodeString(s2)) // accaccacc
	fmt.Println(decodeString(s3)) // abcabccdcdcdef
}
