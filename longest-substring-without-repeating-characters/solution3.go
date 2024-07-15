// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package main

import "fmt"

// T: O(n), S: O(min(n, m))
func lengthOfLongestSubstring(s string) int {
	set := make(map[byte]bool)
	left, right, ans := 0, 0, 0
	for right < len(s) {
		if !set[s[right]] {
			set[s[right]] = true
			right++
		} else {
			set[s[left]] = false
			left++
		}
		ans = max(ans, right-left)
	}
	return ans
}

func main() {
	s1 := "abcabcbb"
	s2 := "bbbbb"
	s3 := "pwwkew"
	fmt.Println(lengthOfLongestSubstring(s1)) // 3
	fmt.Println(lengthOfLongestSubstring(s2)) // 1
	fmt.Println(lengthOfLongestSubstring(s3)) // 3
}
