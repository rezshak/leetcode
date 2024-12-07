// https://leetcode.com/problems/word-break/

package main

import (
	"fmt"
)

// T: O(n*m*t), S: O(n)
func wordBreak(s string, wordDict []string) bool {
	memo := make(map[int]bool)
	memo[len(s)] = true
	return dfs(s, wordDict, 0, memo)
}

func dfs(s string, wordDict []string, i int, memo map[int]bool) bool {
	if val, ok := memo[i]; ok {
		return val
	}

	for _, w := range wordDict {
		if i+len(w) <= len(s) && s[i:i+len(w)] == w {
			if dfs(s, wordDict, i+len(w), memo) {
				memo[i] = true
				return true
			}
		}
	}

	memo[i] = false
	return false
}

func main() {
	s1 := "leetcode"
	wordDict1 := []string{"leet", "code"}
	fmt.Println(wordBreak(s1, wordDict1)) // true

	s2 := "applepenapple"
	wordDict2 := []string{"apple", "pen"}
	fmt.Println(wordBreak(s2, wordDict2)) // true

	s3 := "catsandog"
	wordDict3 := []string{"cats", "dog", "sand", "and", "cat"}
	fmt.Println(wordBreak(s3, wordDict3)) // false

	s4 := ""
	wordDict4 := []string{"a", "b"}
	fmt.Println(wordBreak(s4, wordDict4)) // true

	s5 := "hello"
	wordDict5 := []string{"hello"}
	fmt.Println(wordBreak(s5, wordDict5)) // true

	s6 := "aaaaaaa"
	wordDict6 := []string{"aaaa", "aaa"}
	fmt.Println(wordBreak(s6, wordDict6)) // true
}
