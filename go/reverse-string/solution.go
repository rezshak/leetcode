// https://leetcode.com/problems/reverse-string/

package main

import "fmt"

// T: O(n), S: O(1)
func reverseString(s []byte) {
	left, right := 0, len(s)-1
	for left < right {
		s[left], s[right] = s[right], s[left]
		left++
		right--
	}
}

// T: O(n), S: O(n)
func reverseStringStack(s []byte) {
	stack := make([]byte, len(s))
	copy(stack, s)
	for i := 0; i < len(s); i++ {
		s[i] = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
	}
}

func main() {
	s1 := []byte("hello")
	reverseString(s1)
	fmt.Println(string(s1)) // olleh
	s2 := []byte("Hannah")
	reverseStringStack(s2)
	fmt.Println(string(s2)) // hannaH
}
