// https://leetcode.com/problems/length-of-last-word/

package main

import "fmt"

// T: O(n), S: O(1)
func lengthOfLastWord(s string) int {
	r := len(s) - 1
	for r >= 0 && rune(s[r]) == ' ' {
		r--
	}
	count := 0
	for r >= 0 && rune(s[r]) != ' ' {
		r--
		count++
	}
	return count
}

func main() {
	s1 := "Hello World"
	s2 := "   fly me   to   the moon  "
	s3 := "luffy is still joyboy"
	fmt.Println(lengthOfLastWord(s1)) // 5
	fmt.Println(lengthOfLastWord(s2)) // 4
	fmt.Println(lengthOfLastWord(s3)) // 6
}
