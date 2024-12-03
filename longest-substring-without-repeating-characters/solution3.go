// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package main

import "fmt"

// T: O(n), S: O(min(n, m))
func lengthOfLongestSubstring(s string) int {
	seen := make(map[byte]bool)
	n, maxLen, l := len(s), 0, 0
	for r := 0; r < n; r++ {
		for seen[s[r]] {
			delete(seen, s[l])
			l++
		}
		seen[s[r]] = true
		maxLen = max(maxLen, r-l+1)
	}
	return maxLen
}

func main() {
	s1 := "abcabcbb"
	s2 := "bbbbb"
	s3 := "pwwkew"
	fmt.Println(lengthOfLongestSubstring(s1)) // 3
	fmt.Println(lengthOfLongestSubstring(s2)) // 1
	fmt.Println(lengthOfLongestSubstring(s3)) // 3
}
