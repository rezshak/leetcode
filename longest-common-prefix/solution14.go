// https://leetcode.com/problems/longest-common-prefix/

package main

import (
	"fmt"
	"sort"
	"strings"
)

// T: O(S) where S is sum of all characters, S: O(1)
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	minLen := len(strs[0])
	for _, s := range strs {
		if len(s) < minLen {
			minLen = len(s)
		}
	}

	var result strings.Builder
	for i := 0; i < minLen; i++ {
		ch := strs[0][i]
		for _, s := range strs {
			if s[i] != ch {
				return result.String()
			}
		}
		result.WriteByte(ch)
	}
	return result.String()
}

// T: O(S) where S is sum of all characters, S: O(1)
func longestCommonPrefixOpt1(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	var result strings.Builder
	for i := 0; i < len(strs[0]); i++ {
		ch := strs[0][i]
		for _, s := range strs {
			if i >= len(s) || s[i] != ch {
				return result.String()
			}
		}
		result.WriteByte(ch)
	}
	return result.String()
}

// T: O(n*log(n)) for sorting + O(m) for comparison
// S: O(1) not counting the sort space complexity
func longestCommonPrefixOpt2(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	sort.Strings(strs)
	first, last := strs[0], strs[len(strs)-1]

	i := 0
	for i < len(first) && i < len(last) && first[i] == last[i] {
		i++
	}

	return first[:i]
}

func main() {
	strs1 := []string{"flower", "flow", "flight"}
	strs2 := []string{"dog", "racecar", "car"}
	strs3 := []string{"a"}
	fmt.Println(longestCommonPrefix(strs1))     // fl
	fmt.Println(longestCommonPrefix(strs2))     // ""
	fmt.Println(longestCommonPrefix(strs3))     // a
	fmt.Println(longestCommonPrefixOpt1(strs1)) // fl
	fmt.Println(longestCommonPrefixOpt1(strs2)) // ""
	fmt.Println(longestCommonPrefixOpt1(strs3)) // a
	fmt.Println(longestCommonPrefixOpt2(strs1)) // fl
	fmt.Println(longestCommonPrefixOpt2(strs2)) // ""
	fmt.Println(longestCommonPrefixOpt2(strs3)) // a
}
