// https://leetcode.com/problems/minimum-window-substring/

package main

import (
	"fmt"
	"math"
)

// T: O(n), S: O(k)
func minWindow(s string, t string) string {
	if len(s) == 0 || len(t) == 0 {
		return ""
	}

	tCounts := make(map[rune]int)
	for _, ch := range t {
		tCounts[ch]++
	}
	required := len(tCounts)

	minLeft, minRight, minWinLen := 0, 0, math.MaxInt32
	formed := 0
	winCounts := make(map[rune]int)

	left := 0
	for right, rightChar := range s {
		winCounts[rightChar]++
		if count, ok := tCounts[rightChar]; ok && winCounts[rightChar] == count {
			formed++
		}

		for left <= right && formed == required {
			currWinLen := right - left + 1
			if currWinLen < minWinLen {
				minWinLen = currWinLen
				minLeft = left
				minRight = right
			}

			leftChar := rune(s[left])
			winCounts[leftChar]--
			if count, ok := tCounts[leftChar]; ok && winCounts[leftChar] < count {
				formed--
			}
			left++
		}
	}

	if minWinLen == math.MaxInt32 {
		return ""
	}
	return s[minLeft : minRight+1]
}

func main() {
	s1 := "ADOBECODEBANC"
	t1 := "ABC"
	fmt.Println(minWindow(s1, t1)) // "BANC"
	s2 := "a"
	t2 := "a"
	fmt.Println(minWindow(s2, t2)) // "a"
	s3 := "a"
	t3 := "aa"
	fmt.Println(minWindow(s3, t3)) // ""
}
