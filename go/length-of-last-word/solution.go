// https://leetcode.com/problems/length-of-last-word/

package main

import "fmt"

func lengthOfLastWord(s string) int {
	right := len(s) - 1
	for rune(s[right]) == ' ' {
		right--
	}
	count := 0
	for right >= 0 && rune(s[right]) != ' ' {
		right--
		count++
	}
	return count
}

func main() {
	s1 := "Hello World"
	s2 := "   fly me   to   the moon  "
	fmt.Println(lengthOfLastWord(s1))
	fmt.Println(lengthOfLastWord(s2))
}
