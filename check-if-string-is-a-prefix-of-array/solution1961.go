// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/

package main

import "fmt"

// T: O(n), S: O(1)
func isPrefixString(s string, words []string) bool {
	n, i := len(s), 0
	for _, w := range words {
		if i == n {
			break
		}
		for _, ch := range w {
			if i >= n || ch != rune(s[i]) {
				return false
			}
			i++
		}
	}
	return i == n
}

func main() {
	s1 := "iloveleetcode"
	words1 := []string{"i", "love", "leetcode", "apples"}
	words2 := []string{"apples", "i", "love", "leetcode"}
	words3 := []string{"a"}
	fmt.Println(isPrefixString(s1, words1)) // true
	fmt.Println(isPrefixString(s1, words2)) // false
	fmt.Println(isPrefixString(s1, words3)) // false
}
