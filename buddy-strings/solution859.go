// https://leetcode.com/problems/buddy-strings/

package main

import "fmt"

// T: O(n), S: O(1)
func buddyStrings(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}
	// Edge case
	if s == goal {
		counts := [26]byte{}
		for _, ch := range s {
			counts[ch-'a']++
			if counts[ch-'a'] == 2 {
				return true
			}
		}
		return false
	}
	n, diffCount := len(s), 0
	sCounts, gCounts := [26]int{}, [26]int{}
	for i := 0; i < n; i++ {
		sCounts[s[i]-'a']++
		gCounts[goal[i]-'a']++
		if s[i] != goal[i] {
			diffCount++
			if diffCount > 2 {
				return false
			}
		}
	}
	return diffCount == 2 && sCounts == gCounts
}

func main() {
	fmt.Println(buddyStrings("ab", "ba")) // true
	fmt.Println(buddyStrings("ab", "ab")) // false
	fmt.Println(buddyStrings("aa", "aa")) // true
}
