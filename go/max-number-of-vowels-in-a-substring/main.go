// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

package main

import (
	"fmt"
	"strings"
)

const VOWELS = "aeiou"

// T: O(n), S: O(1)
func maxVowels(s string, k int) int {
	maxCount, currCount := 0, 0
	for i := 0; i < k; i++ {
		currCh := rune(s[i])
		if strings.ContainsRune(VOWELS, currCh) {
			currCount++
		}
	}
	maxCount = currCount
	for i := k; i < len(s); i++ {
		currCh := rune(s[i])
		if strings.ContainsRune(VOWELS, currCh) {
			currCount++
		}
		prevCh := rune(s[i-k])
		if strings.ContainsRune(VOWELS, prevCh) {
			currCount--
		}
		if currCount > maxCount {
			maxCount = currCount
		}
	}
	return maxCount
}

func main() {
	s1 := "abciiidef"
	s2 := "aeiou"
	s3 := "leetcode"
	fmt.Println(maxVowels(s1, 3)) // 3
	fmt.Println(maxVowels(s2, 2)) // 2
	fmt.Println(maxVowels(s3, 3)) // 2
}
