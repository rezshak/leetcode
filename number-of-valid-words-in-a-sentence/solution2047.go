// https://leetcode.com/problems/number-of-valid-words-in-a-sentence/

package main

import (
	"fmt"
	"strings"
	"unicode"
)

// T: O(n), S: O(n)
func countValidWords(sentence string) int {
	words := strings.Fields(sentence)
	count := 0
	for _, word := range words {
		if isValid(word) {
			count++
		}
	}
	return count
}

func isValid(word string) bool {
	hasHyphen := false
	for i, ch := range word {
		if unicode.IsDigit(ch) {
			return false
		}
		if unicode.IsPunct(ch) {
			if ch != '!' && ch != '.' && ch != ',' {
				return false
			}
			if i != len(word)-1 {
				return false
			}
		}
		if ch == '-' {
			if hasHyphen || i == 0 || i == len(word)-1 || !unicode.IsLetter(rune(word[i-1])) || !unicode.IsLetter(rune(word[i+1])) {
				return false
			}
			hasHyphen = true
		}
	}
	return true
}

func main() {
	sent1 := "cat and  dog"
	sent2 := "!this  1-s b8d!"
	sent3 := "alice and  bob are playing stone-game10"
	fmt.Println(countValidWords(sent1)) // 3
	fmt.Println(countValidWords(sent2)) // 0
	fmt.Println(countValidWords(sent3)) // 5
}
