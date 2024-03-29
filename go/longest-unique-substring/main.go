// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package main

import "fmt"

// T: O(n), S: O(min(n, m))
func lengthOfLongestSubstring(s string) int {
	beg := 0
	end := 0
	max := 0
	set := make(map[rune]bool)
	for end < len(s) {
		if _, ok := set[rune(s[end])]; !ok {
			set[rune(s[end])] = true
			end++
		} else {
			delete(set, rune(s[beg]))
			beg++
		}
		max = maxInt(max, end-beg)
	}
	return max
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	s1 := "abcabcbb" // 3
	s2 := "bbbbb"    // 1
	s3 := "pwwkew"   // 3
	fmt.Println(lengthOfLongestSubstring(s1))
	fmt.Println(lengthOfLongestSubstring(s2))
	fmt.Println(lengthOfLongestSubstring(s3))
}
