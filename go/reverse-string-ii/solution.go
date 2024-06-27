// https://leetcode.com/problems/reverse-string-ii/

package main

import "fmt"

// T: O(n), S: O(n)
func reverseStr(s string, k int) string {
	arr := []rune(s)
	for i := 0; i < len(arr); i += 2 * k {
		beg, end := i, min(i+k-1, len(arr)-1)
		for beg < end {
			arr[beg], arr[end] = arr[end], arr[beg]
			beg++
			end--
		}
	}
	return string(arr)
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	s1 := "abcdefg"
	s2 := "abcd"
	fmt.Println(reverseStr(s1, 2)) // "bacdfeg"
	fmt.Println(reverseStr(s2, 2)) // "bacd"
}
