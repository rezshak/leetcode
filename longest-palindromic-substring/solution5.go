package main

import (
	"fmt"
)

// Two pointer, expand around the center
// T: O(n^2), S: O(1)
func longestPalindrome(s string) string {
	resLen, resIdx := 0, 0

	for i := 0; i < len(s); i++ {
		// Odd length
		l, r := i, i
		for l >= 0 && r < len(s) && s[l] == s[r] {
			if r-l+1 > resLen {
				resIdx = l
				resLen = r - l + 1
			}
			l--
			r++
		}
		// Even length
		l, r = i, i+1
		for l >= 0 && r < len(s) && s[l] == s[r] {
			if r-l+1 > resLen {
				resIdx = l
				resLen = r - l + 1
			}
			l--
			r++
		}
	}

	return s[resIdx : resIdx+resLen]
}

// T: O(n^2), S: O(1)
func longestPalindromeBetterBrute(s string) string {
	res := ""
	resLen := 0

	for i := 0; i < len(s); i++ {
		for j := i; j < len(s); j++ {
			l, r := i, j
			for l < r && s[l] == s[r] {
				l++
				r--
			}

			if l >= r && resLen < (j-i+1) {
				res = s[i : j+1]
				resLen = j - i + 1
			}
		}
	}

	return res
}

// T: O(n^2), S: O(n^2)
func longestPalindromeDp(s string) string {
	resIdx, resLen := 0, 0
	n := len(s)

	dp := make([][]bool, n)
	for i := range dp {
		dp[i] = make([]bool, n)
	}

	for i := n - 1; i >= 0; i-- {
		for j := i; j < n; j++ {
			if s[i] == s[j] && (j-i <= 2 || dp[i+1][j-1]) {
				dp[i][j] = true
				if resLen < (j - i + 1) {
					resIdx = i
					resLen = j - i + 1
				}
			}
		}
	}

	return s[resIdx : resIdx+resLen]
}

// T: O(n^3), S: O(1)
func longestPalindromeBrute(s string) string {
	res := ""
	resLen := 0
	for i := 0; i < len(s); i++ {
		for j := i; j < len(s); j++ {
			substr := s[i : j+1]
			if isPalindrome(substr) && len(substr) > resLen {
				res = substr
				resLen = len(substr)
			}
		}
	}
	return res
}

// T: O(k), S: O(1)
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
	s1 := "babad"
	s2 := "cbbd"
	s3 := "a"
	fmt.Println(longestPalindrome(s1))            // "bab" or "aba"
	fmt.Println(longestPalindromeBrute(s1))       // "bab" or "aba"
	fmt.Println(longestPalindromeBetterBrute(s1)) // "bab" or "aba"
	fmt.Println(longestPalindrome(s2))            // "bb"
	fmt.Println(longestPalindromeBrute(s2))       // "bb"
	fmt.Println(longestPalindromeBetterBrute(s2)) // "bb"
	fmt.Println(longestPalindrome(s3))            // "a"
	fmt.Println(longestPalindromeBrute(s3))       // "a"
	fmt.Println(longestPalindromeBetterBrute(s3)) // "a"
}
