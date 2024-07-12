// https://leetcode.com/problems/minimum-window-substring/

package main

import (
	"fmt"
	"math"
)

// T: O(n+m), S: O(m)
func minWindow(s string, t string) string {
	if len(s) == 0 || len(t) == 0 {
		return ""
	}

	tFreq := make(map[rune]int)
	for _, ch := range t {
		tFreq[ch]++
	}

	left, minLeft, minLen, count := 0, 0, math.MaxInt32, 0

	for right, rChar := range s {
		if _, exists := tFreq[rChar]; exists {
			tFreq[rChar]--
			if tFreq[rChar] >= 0 {
				count++
			}
		}

		for count == len(t) {
			if right-left+1 < minLen {
				minLeft = left
				minLen = right - left + 1
			}

			lChar := rune(s[left])
			if _, exists := tFreq[lChar]; exists {
				tFreq[lChar]++
				if tFreq[lChar] > 0 {
					count--
				}
			}
			left++
		}
	}

	if minLen == math.MaxInt32 {
		return ""
	}

	return s[minLeft : minLeft+minLen]
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
