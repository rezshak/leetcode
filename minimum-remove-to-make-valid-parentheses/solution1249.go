// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func minRemoveToMakeValid(s string) string {
	n := len(s)
	stack := [][]int{} // ch, i
	arr := []rune(s)
	for i := 0; i < n; i++ {
		ch := arr[i]
		if len(stack) > 0 && stack[len(stack)-1][0] == '(' && ch == ')' {
			stack = stack[:len(stack)-1]
		} else if ch == '(' || ch == ')' {
			stack = append(stack, []int{int(ch), i})
		}
	}
	sb := strings.Builder{}
	for i := n - 1; i >= 0; i-- {
		if len(stack) > 0 && stack[len(stack)-1][1] == i {
			stack = stack[:len(stack)-1]
		} else {
			sb.WriteRune(arr[i])
		}
	}
	return reverseString(sb.String())
}

func reverseString(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	s1 := "lee(t(c)o)de)"
	s2 := "a)b(c)d"
	s3 := "))(("
	fmt.Println(minRemoveToMakeValid(s1)) // "lee(t(c)o)de"
	fmt.Println(minRemoveToMakeValid(s2)) // "ab(c)d"
	fmt.Println(minRemoveToMakeValid(s3)) // ""
}
