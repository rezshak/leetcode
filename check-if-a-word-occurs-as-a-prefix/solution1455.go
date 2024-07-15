// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

package main

import (
	"fmt"
	"strings"
)

// T: O(nm), S: O(n)
func isPrefixOfWordEasy(sentence, searchWord string) int {
	arr := strings.Split(sentence, " ")
	for i, w := range arr {
		if strings.HasPrefix(w, searchWord) {
			return i + 1
		}
	}
	return -1
}

// T: O(n), S: O(1)
func isPrefixOfWord(sentence, searchWord string) int {
	n, m := len(sentence), len(searchWord)
	i, j := 0, 0
	wordIdx := 1
	for i < n {
		if sentence[i] == ' ' {
			j = 0
			wordIdx++
			i++
		} else {
			if sentence[i] == searchWord[j] {
				for i < n && sentence[i] == searchWord[j] {
					i++
					j++
					if j == m {
						return wordIdx
					}
				}
			} else {
				for i < n && sentence[i] != ' ' {
					i++
				}
			}
		}
	}
	return -1
}

func main() {
	sent1 := "i love eating burger"
	sent2 := "this problem is an easy problem"
	sent3 := "i am tired"
	sent4 := "hellohello hellohellohello"
	fmt.Println(isPrefixOfWordEasy(sent1, "burg")) // 4
	fmt.Println(isPrefixOfWord(sent1, "burg"))     // 4
	fmt.Println(isPrefixOfWordEasy(sent2, "pro"))  // 2
	fmt.Println(isPrefixOfWord(sent2, "pro"))      // 2
	fmt.Println(isPrefixOfWordEasy(sent3, "you"))  // -1
	fmt.Println(isPrefixOfWord(sent3, "you"))      // -1
	fmt.Println(isPrefixOfWordEasy(sent4, "ell"))  // -1
	fmt.Println(isPrefixOfWord(sent4, "ell"))      // -1
}
