// https://leetcode.com/problems/reverse-words-in-a-string/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func reverseWords(s string) string {
	arr := strings.Fields(s)
	left, right := 0, len(arr)-1
	for left < right {
		arr[left], arr[right] = arr[right], arr[left]
		left++
		right--
	}
	return strings.Join(arr, " ")
}

func main() {
	s1 := "a good   example"
	s2 := "world hello"
	s3 := "a good   example"
	fmt.Println(reverseWords(s1)) // "example good a"
	fmt.Println(reverseWords(s2)) // "hello world"
	fmt.Println(reverseWords(s3)) // "example good a"
}
