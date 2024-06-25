// https://leetcode.com/problems/assign-cookies/

package main

import (
	"fmt"
	"sort"
)

// T: O(nlogn), S: O(1)
func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	gIdx, sIdx, count := 0, 0, 0
	for gIdx < len(g) && sIdx < len(s) {
		if s[sIdx] >= g[gIdx] {
			count++
			sIdx++
			gIdx++
		} else {
			sIdx++
		}
	}
	return count
}

func main() {
	g1 := []int{1, 2, 3}
	s1 := []int{1, 1}
	fmt.Println(findContentChildren(g1, s1)) // 1
	g2 := []int{1, 2}
	s2 := []int{1, 2, 3}
	fmt.Println(findContentChildren(g2, s2)) // 2
}
