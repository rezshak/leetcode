// https://leetcode.com/problems/reverse-only-letters/

package main

import (
	"fmt"
	"strings"
	"unicode"
)

// T: O(n), S: O(n)
func reverseOnlyLetters(s string) string {
	runes := []rune(s)
	left, right := 0, len(s)-1
	for left < right {
		leftChar, rightChar := runes[left], runes[right]
		if unicode.IsLetter(leftChar) && unicode.IsLetter(rightChar) {
			runes[left], runes[right] = runes[right], runes[left]
			left++
			right--
		} else if !unicode.IsLetter(leftChar) {
			left++
		} else if !unicode.IsLetter(rightChar) {
			right--
		}
	}
	return string(runes)
}

// T: O(n), S: O(n)
func reverseOnlyLettersStack(s string) string {
	st := make([]rune, 0)
	for _, ch := range s {
		if unicode.IsLetter(ch) {
			st = append(st, ch)
		}
	}
	var sb strings.Builder
	for _, ch := range s {
		if unicode.IsLetter(ch) {
			lastIdx := len(st) - 1
			sb.WriteRune(st[lastIdx])
			st = st[:lastIdx]
		} else {
			sb.WriteRune(ch)
		}
	}
	return sb.String()
}

func main() {
	s1 := "ab-cd"
	s2 := "a-bC-dEf-ghIj"
	s3 := "Test1ng-Leet=code-Q!"
	fmt.Println(reverseOnlyLetters(s1))      // "dc-ba"
	fmt.Println(reverseOnlyLettersStack(s1)) // "dc-ba"
	fmt.Println(reverseOnlyLetters(s2))      // "j-Ih-gfE-dCba"
	fmt.Println(reverseOnlyLettersStack(s2)) // "j-Ih-gfE-dCba"
	fmt.Println(reverseOnlyLetters(s3))      // "Qedo1ct-eeLg=ntse-T!"
	fmt.Println(reverseOnlyLettersStack(s3)) // "Qedo1ct-eeLg=ntse-T!"
}
