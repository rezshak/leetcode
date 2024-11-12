// https://leetcode.com/problems/valid-word-abbreviation/

package main

import (
	"fmt"
	"unicode"
)

// T: O(n), S: O(1)
func validWordAbbreviation(word string, abbr string) bool {
	wordLen, abbrLen := len(word), len(abbr)
	wordIdx, abbrIdx := 0, 0
	for wordIdx < wordLen && abbrIdx < abbrLen {
		if unicode.IsDigit(rune(abbr[abbrIdx])) {
			if abbr[abbrIdx] == '0' {
				return false
			}
			num := 0
			for abbrIdx < abbrLen && unicode.IsDigit(rune(abbr[abbrIdx])) {
				digit := int(abbr[abbrIdx] - '0')
				num = num*10 + digit
				abbrIdx++
			}
			wordIdx += num
		} else {
			if wordIdx >= wordLen || word[wordIdx] != abbr[abbrIdx] {
				return false
			}
			wordIdx++
			abbrIdx++
		}
	}
	return wordIdx == wordLen && abbrIdx == abbrLen
}

func main() {
	w1, a1 := "internationalization", "i12iz4n"
	fmt.Println(validWordAbbreviation(w1, a1)) // true
	w2, a2 := "apple", "a2e"
	fmt.Println(validWordAbbreviation(w2, a2)) // false
	w3, a3 := "internationalization", "i5a11o1"
	fmt.Println(validWordAbbreviation(w3, a3)) // true
}
