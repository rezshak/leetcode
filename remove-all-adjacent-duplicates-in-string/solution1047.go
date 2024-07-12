// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

package main

import "fmt"

// T: O(n), S: O(n)
func removeDuplicates(str string) string {
	stack := make([]rune, 0)
	for _, ch := range str {
		if len(stack) != 0 && stack[len(stack)-1] == ch {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, ch)
		}
	}
	return string(stack)
}

func main() {
	var s1 = "abbaca"
	var s2 = "azxxzy"
	fmt.Println(removeDuplicates(s1)) // "ca"
	fmt.Println(removeDuplicates(s2)) // "ay"
}
