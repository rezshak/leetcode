// https://leetcode.com/problems/longest-repeating-character-replacement/

package main

import "fmt"

// T: O(n), S: O(1)
func characterReplacement(s string, k int) int {
	result, left, mostFreqCount := 0, 0, 0
	counts := make(map[rune]int)
	for right := 0; right < len(s); right++ {
		rightChar := rune(s[right])
		counts[rightChar]++
		mostFreqCount = max(mostFreqCount, counts[rightChar])
		windowValid := right-left+1-mostFreqCount <= k
		if !windowValid {
			leftChar := rune(s[left])
			counts[leftChar]--
			left++
		}
		result = max(result, right-left+1)
	}
	return result
}

func main() {
	var s1 = "ABAB"
	var s2 = "AABABBA"
	fmt.Println(characterReplacement(s1, 2)) // 4
	fmt.Println(characterReplacement(s2, 1)) // 4
}
