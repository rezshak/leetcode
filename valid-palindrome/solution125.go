// https://leetcode.com/problems/valid-palindrome/

package main

import (
	"fmt"
	"strings"
	"unicode"
)

// T: O(n), S: O(1)
func isPalindrome(s string) bool {
	s = strings.ToLower(strings.TrimSpace(s))
	left, right := 0, len(s)-1
	for left < right {
		leftChar := rune(s[left])
		rightChar := rune(s[right])
		if !unicode.IsLetter(leftChar) && !unicode.IsDigit(leftChar) {
			left++
			continue
		}
		if !unicode.IsLetter(rightChar) && !unicode.IsDigit(rightChar) {
			right--
			continue
		}
		if leftChar != rightChar {
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
