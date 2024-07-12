// https://leetcode.com/problems/removing-stars-from-a-string/

package main

import "fmt"

// T: O(n), S: O(n)
func removeStars(s string) string {
	stack := make([]rune, 0)
	for _, ch := range s {
		if ch == '*' {
			if len(stack) != 0 {
				stack = stack[:len(stack)-1]
			}
		} else {
			stack = append(stack, ch)
		}
	}
	return string(stack)
}

func main() {
	var s1 = "leet**cod*e"
	var s2 = "erase*****"
	fmt.Println(removeStars(s1)) // "lecoe"
	fmt.Println(removeStars(s2)) // ""
}
