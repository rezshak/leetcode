// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

package main

import "fmt"

// T: O(nm), S: O(1)
func firstPalindrome(words []string) string {
	for _, w := range words {
		if isPalindrome(w) {
			return w
		}
	}
	return ""
}

func isPalindrome(word string) bool {
	for i, j := 0, len(word)-1; i < j; i, j = i+1, j-1 {
		if word[i] != word[j] {
			return false
		}
	}
	return true
}

func main() {
	var words1 = []string{"abc", "car", "ada", "racecar", "cool"}
	var words2 = []string{"notapalindrome", "racecar"}
	var words3 = []string{"def", "ghi"}
	fmt.Println(firstPalindrome(words1)) // "ada"
	fmt.Println(firstPalindrome(words2)) // "racecar"
	fmt.Println(firstPalindrome(words3)) // ""
}
