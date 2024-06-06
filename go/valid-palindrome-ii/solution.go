// https://leetcode.com/problems/valid-palindrome-ii/

package main

import "fmt"

// T: O(n), S:(1)
func validPalindrome(s string) bool {
	left, right := 0, len(s)-1
	for left < right {
		if s[left] != s[right] {
			return palindromeHelper(s, left, right-1) ||
				palindromeHelper(s, left+1, right)
		}
		left++
		right--
	}
	return true
}

func palindromeHelper(s string, i, j int) bool {
	for i < j {
		if s[i] != s[j] {
			return false
		}
		i++
		j--
	}
	return true
}

func main() {
	var s1 = "aba"
	var s2 = "abca"
	var s3 = "abc"
	fmt.Println(validPalindrome(s1)) // true
	fmt.Println(validPalindrome(s2)) // true
	fmt.Println(validPalindrome(s3)) // false
}
