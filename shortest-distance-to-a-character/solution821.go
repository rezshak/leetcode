// https://leetcode.com/problems/shortest-distance-to-a-character/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func shortestToChar(s string, c byte) []int {
	n := len(s)
	ans := make([]int, n)
	dist := n
	for i := 0; i < n; i++ {
		if s[i] == c {
			dist = 0
		} else {
			dist++
		}
		ans[i] = dist
	}
	for i := n - 1; i >= 0; i-- {
		if s[i] == c {
			dist = 0
		} else {
			dist++
		}
		ans[i] = min(ans[i], dist)
	}
	return ans
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	s1 := "loveleetcode"
	s2 := "aaab"
	fmt.Println(shortestToChar(s1, 'e')) // [3,2,1,0,1,0,0,1,2,2,1,0]
	fmt.Println(shortestToChar(s2, 'b')) // [3,2,1,0]
}
