// https://leetcode.com/problems/determine-if-two-strings-are-close/

package main

import (
	"fmt"
	"sort"
)

// T: O(n), S: O(n)
func closeStrings(word1 string, word2 string) bool {
	if len(word1) != len(word2) {
		return false
	}
	counts1 := make(map[rune]int)
	for _, ch := range word1 {
		counts1[ch]++
	}
	counts2 := make(map[rune]int)
	for _, ch := range word2 {
		if _, ok := counts1[ch]; !ok {
			return false
		}
		counts2[ch]++
	}
	values1 := make([]int, 0, len(counts1))
	for _, v := range counts1 {
		values1 = append(values1, v)
	}
	values2 := make([]int, 0, len(counts2))
	for _, v := range counts2 {
		values2 = append(values2, v)
	}
	sort.Ints(values1)
	sort.Ints(values2)
	for i, v := range values1 {
		if v != values2[i] {
			return false
		}
	}
	return true
}

func main() {
	word1 := "abc"
	word2 := "bca"
	fmt.Println(closeStrings(word1, word2)) // true
	word1 = "a"
	word2 = "aa"
	fmt.Println(closeStrings(word1, word2)) // false
	word1 = "cabbba"
	word2 = "abbccc"
	fmt.Println(closeStrings(word1, word2)) // true
}
