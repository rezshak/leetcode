package main

import "fmt"

// Two pointer, expand around center
// T: O(n^2), S: O(1)
func countSubstrings(s string) int {
	res := 0
	for i := 0; i < len(s); i++ {
		res += countPalindrome(s, i, i)
		res += countPalindrome(s, i, i+1)
	}
	return res
}

// T: O(n), S: O(1)
func countPalindrome(s string, l, r int) int {
	res := 0
	for l >= 0 && r < len(s) && s[l] == s[r] {
		res++
		l--
		r++
	}
	return res
}

// T: O(n^2), S: O(n^2)
func countSubstringsDp(s string) int {
	n := len(s)
	res := 0
	dp := make([][]bool, n)
	for i := range dp {
		dp[i] = make([]bool, n)
	}

	for i := n - 1; i >= 0; i-- {
		for j := i; j < n; j++ {
			if s[i] == s[j] && (j-i <= 2 || dp[i+1][j-1]) {
				dp[i][j] = true
				res++
			}
		}
	}

	return res
}

// T: O(n^3), S: O(1)
func countSubstringsBrute(s string) int {
	res := 0

	for i := 0; i < len(s); i++ {
		for j := i; j < len(s); j++ {
			l, r := i, j
			for l < r && s[l] == s[r] {
				l++
				r--
			}
			if l >= r {
				res++
			}
		}
	}

	return res
}

func main() {
	s1 := "abc"
	s2 := "aaa"
	fmt.Println(countSubstrings(s1))      // 3
	fmt.Println(countSubstringsBrute(s1)) // 3
	fmt.Println(countSubstringsDp(s1))    // 3
	fmt.Println(countSubstrings(s2))      // 6
	fmt.Println(countSubstringsDp(s2))    // 6
	fmt.Println(countSubstringsBrute(s2)) // 6
}
