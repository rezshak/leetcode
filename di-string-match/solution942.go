// https://leetcode.com/problems/di-string-match/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func diStringMatch(s string) []int {
	n := len(s)
	low, high := 0, n
	perm := make([]int, n+1)

	for i := 0; i < n; i++ {
		if s[i] == 'I' {
			perm[i] = low
			low++
		} else {
			perm[i] = high
			high--
		}
	}
	perm[n] = low // or high, since low == high at this point
	return perm
}

func main() {
	sol := diStringMatch
	s1 := "IDID"
	s2 := "III"
	s3 := "DDI"
	fmt.Println(sol(s1)) // [0,4,1,3,2]
	fmt.Println(sol(s2)) // [0,1,2,3]
	fmt.Println(sol(s3)) // [3,2,0,1]
}
