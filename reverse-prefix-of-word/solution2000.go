// https://leetcode.com/problems/reverse-prefix-of-word/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func reversePrefix(word string, ch byte) string {
	chIdx := strings.IndexByte(word, ch)
	if chIdx == -1 {
		return word
	}
	// Convert string to a slice of bytes for in-place modification
	bytes := []byte(word)
	// Reverse the prefix in place
	for i, j := 0, chIdx; i < j; i, j = i+1, j-1 {
		bytes[i], bytes[j] = bytes[j], bytes[i]
	}
	return string(bytes)
}

// T: O(n), S: O(n)
func reversePrefixSb(word string, ch byte) string {
	chIdx := strings.IndexByte(word, ch)
	if chIdx == -1 {
		return word
	}
	var sb strings.Builder
	for i := chIdx; i >= 0; i-- {
		sb.WriteByte(word[i])
	}
	for i := chIdx + 1; i < len(word); i++ {
		sb.WriteByte(word[i])
	}
	return sb.String()
}

func main() {
	w1 := "abcdefd"
	w2 := "xyxzxe"
	w3 := "abcd"
	fmt.Println(reversePrefix(w1, 'd'))   // "dcbaefd"
	fmt.Println(reversePrefixSb(w1, 'd')) // "dcbaefd"
	fmt.Println(reversePrefix(w2, 'z'))   // "zxyxxe"
	fmt.Println(reversePrefixSb(w2, 'z')) // "zxyxxe"
	fmt.Println(reversePrefix(w3, 'z'))   // "abcd"
	fmt.Println(reversePrefixSb(w3, 'z')) // "abcd"
}
