// https://leetcode.com/problems/remove-palindromic-subsequences/

package main

import "fmt"

// T: O(n), S: O(1)
func removePalindromeSub(s string) int {
	if s == "" {
		return 0
	}
	if isPalindrome(s) {
		return 1
	}
	return 2
}

func isPalindrome(s string) bool {
	left, right := 0, len(s)-1
	for left < right {
		if s[left] != s[right] {
			return false
		}
		left++
		right--
	}
	return true
}

func main() {
	s1 := "ababa"
	s2 := "abb"
	s3 := "baabb"
	fmt.Println(removePalindromeSub(s1)) // 1
	fmt.Println(removePalindromeSub(s2)) // 2
	fmt.Println(removePalindromeSub(s3)) // 2
}
