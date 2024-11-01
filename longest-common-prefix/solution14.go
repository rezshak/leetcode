// https://leetcode.com/problems/longest-common-prefix/

package main

import (
	"fmt"
	"strings"
)

type Solution14 struct{}

// T: O(n*m^2), S: O(1)
func longestCommonPrefix(strs []string) string {
	endIdx := 0
	result := ""
	for i := 0; i < len(strs[0]); i++ {
		candidate := strs[0][:endIdx+1]
		for j := 1; j < len(strs); j++ {
			if !strings.HasPrefix(strs[j], candidate) {
				return result
			}
		}
		result = candidate
		endIdx++
	}
	return result
}

// T: O(n*m), S: O(1)
func longestCommonPrefixOpt(strs []string) string {
	var sb strings.Builder
	for i := 0; i < len(strs[0]); i++ {
		ch := strs[0][i]
		for _, str := range strs {
			if i >= len(str) || str[i] != ch {
				return sb.String()
			}
		}
		sb.WriteByte(ch)
	}
	return sb.String()
}

func main() {
	strs1 := []string{"flower", "flow", "flight"}
	strs2 := []string{"dog", "racecar", "car"}
	strs3 := []string{"a"}
	fmt.Println(longestCommonPrefix(strs1))    // fl
	fmt.Println(longestCommonPrefix(strs2))    // ""
	fmt.Println(longestCommonPrefix(strs3))    // a
	fmt.Println(longestCommonPrefixOpt(strs1)) // fl
	fmt.Println(longestCommonPrefixOpt(strs2)) // ""
	fmt.Println(longestCommonPrefixOpt(strs3)) // a
}
