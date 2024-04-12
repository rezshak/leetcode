// https://leetcode.com/problems/valid-palindrome/

package main

import (
	"fmt"
	"strings"
	"unicode"
)

// T: O(n), S: O(1)
func isPalindrome(s string) bool {
	s = strings.ToLower(s)
	left, right := 0, len(s)-1
	for left < right {
		lch := rune(s[left])
		rch := rune(s[right])
		if !unicode.IsLetter(lch) && !unicode.IsDigit(lch) {
			left++
			continue
		}
		if !unicode.IsLetter(rch) && !unicode.IsDigit(rch) {
			right--
			continue
		}
		if lch != rch {
			return false
		}
		left++
		right--
	}
	return true
}

// T: O(n), S: O(n)
func isPalindromeDeque(s string) bool {
	dq := make([]rune, 0)
	for _, r := range s {
		if unicode.IsLetter(r) || unicode.IsDigit(r) {
			dq = append(dq, unicode.ToLower(r))
		}
	}
	for len(dq) > 1 {
		lch, rch := dq[0], dq[len(dq)-1]
		if lch != rch {
			return false
		}
		dq = dq[1 : len(dq)-1]
	}
	return true
}

func main() {
	s1 := "A man, a plan, a canal: Panama" // true
	s2 := "race a car"                     // false
	fmt.Println(s1, isPalindrome(s1))
	fmt.Println(s1, isPalindromeDeque(s1))
	fmt.Println(s2, isPalindrome(s2))
	fmt.Println(s2, isPalindromeDeque(s2))
}
