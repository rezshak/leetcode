// https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func minMovesToMakePalindrome(s string) int {
	moves := 0
	l, r := 0, len(s)-1
	arr := []rune(s)

	for l < r {
		m := r
		for m > l && arr[m] != arr[l] {
			m--
		}
		if m == l {
			arr[l], arr[l+1] = arr[l+1], arr[l]
			moves++
			continue
		}
		for m < r {
			arr[m], arr[m+1] = arr[m+1], arr[m]
			m++
			moves++
		}
		l++
		r--
	}
	return moves
}

func main() {
	s1 := "aabb"
	s2 := "letelt"
	fmt.Println(minMovesToMakePalindrome(s1)) // 2
	fmt.Println(minMovesToMakePalindrome(s2)) // 2
}
