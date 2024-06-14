// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

package main

import "fmt"

// T: O(nm), S: O(1)
func strStr(haystack string, needle string) int {
	if len(needle) == 0 {
		return 0
	}
	hIdx, nIdx := 0, 0
	for hIdx < len(haystack) && nIdx < len(needle) {
		if haystack[hIdx] == needle[nIdx] {
			hIdx++
			nIdx++
		} else {
			hIdx -= nIdx - 1
			nIdx = 0
		}
		if nIdx == len(needle) {
			return hIdx - len(needle)
		}
	}
	return -1
}

func main() {
	fmt.Println(strStr("sadbutsad", "sad"))     // 0
	fmt.Println(strStr("leetcode", "leeto"))    // -1
	fmt.Println(strStr("mississippi", "issip")) // 4
	fmt.Println(strStr("mississippi", ""))      // 0
}
