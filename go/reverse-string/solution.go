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

func main() {
	s := []byte("hello")
	reverseString(s)
	fmt.Println(string(s)) // olleh
}
