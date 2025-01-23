// https://leetcode.com/problems/longest-substring-without-repeating-characters/

package main

import "fmt"

// T: O(n), S: O(k) where k is the unique characters in the string
func lengthOfLongestSubstring(s string) int {
	seen := make(map[byte]bool)
	left, right := 0, 0
	result := 0
	for right < len(s) {
		if seen[s[right]] {
			delete(seen, s[left])
			left++
		} else {
			seen[s[right]] = true
			right++
			result = max(result, right-left)
		}
	}
	return result
}

// T: O(n), S: O(k)
func lengthOfLongestSubstringOpt(s string) int {
	indices := make(map[byte]int)
	result := 0
	for left, right := 0, 0; right < len(s); right++ {
		curr := s[right]
		if prevIdx, found := indices[curr]; found && prevIdx >= left {
			left = prevIdx + 1
		}
		indices[curr] = right
		result = max(result, right-left+1)
	}
	return result
}

func main() {
	s1 := "abcabcbb"
	s2 := "bbbbb"
	s3 := "pwwkew"
	s4 := "aab"
	fmt.Println(lengthOfLongestSubstring(s1))    // 3
	fmt.Println(lengthOfLongestSubstringOpt(s1)) // 3
	fmt.Println(lengthOfLongestSubstring(s2))    // 1
	fmt.Println(lengthOfLongestSubstringOpt(s2)) // 1
	fmt.Println(lengthOfLongestSubstring(s3))    // 3
	fmt.Println(lengthOfLongestSubstringOpt(s3)) // 3
	fmt.Println(lengthOfLongestSubstring(s4))    // 2
	fmt.Println(lengthOfLongestSubstringOpt(s4)) // 2
}
