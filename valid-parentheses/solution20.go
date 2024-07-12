// https://leetcode.com/problems/valid-parentheses/

package main

import "fmt"

var openSyms = map[rune]bool{
	'{': true,
	'[': true,
	'(': true,
}

var closeSyms = map[rune]rune{
	'}': '{',
	']': '[',
	')': '(',
}

// T: O(n), S: O(n)
func isValid(s string) bool {
	stack := make([]rune, 0)
	for _, ch := range s {
		if openSyms[ch] {
			stack = append(stack, ch)
		} else if _, ok := closeSyms[ch]; ok {
			if len(stack) == 0 {
				return false
			}
			top := stack[len(stack)-1]
			if closeSyms[ch] != top {
				return false
			}
			stack = stack[:len(stack)-1]
		}
	}
	return len(stack) == 0
}

func main() {
	var s1 = "()"
	var s2 = "()[]{}"
	var s3 = "(]"
	fmt.Println(isValid(s1)) // true
	fmt.Println(isValid(s2)) // true
	fmt.Println(isValid(s3)) // false
}
