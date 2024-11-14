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

func removeDuplicates2(s string) string {
	st := []rune{}
	for _, ch := range s {
		if len(st) > 0 && st[len(st)-1] == ch {
			st = st[:len(st)-1]
		} else {
			st = append(st, ch)
		}
	}
	return string(st)
}

func main() {
	s1 := "abbaca"
	s2 := "azxxzy"
	fmt.Println(removeDuplicates(s1))  // "ca"
	fmt.Println(removeDuplicates2(s1)) // "ca"
	fmt.Println(removeDuplicates(s2))  // "ay"
	fmt.Println(removeDuplicates2(s2)) // "ay"
}
