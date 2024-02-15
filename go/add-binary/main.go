// https://leetcode.com/problems/add-binary/description/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func addBinary(a string, b string) string {
	var sb strings.Builder
	ptr1, ptr2 := len(a)-1, len(b)-1
	carry := 0
	for ptr1 >= 0 || ptr2 >= 0 {
		if ptr1 >= 0 {
			carry += int(a[ptr1] - '0')
			ptr1--
		}
		if ptr2 >= 0 {
			carry += int(b[ptr2] - '0')
			ptr2--
		}
		sb.WriteString(fmt.Sprintf("%d", carry%2))
		carry /= 2
	}
	if carry > 0 {
		sb.WriteString(fmt.Sprintf("%d", carry))
	}
	return reverse(sb.String())
}

func reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	s1, s2 := "11", "1" // 100
	fmt.Println(addBinary(s1, s2))
}
