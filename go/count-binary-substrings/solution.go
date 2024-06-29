// https://leetcode.com/problems/count-binary-substrings/

package main

import "fmt"

// T: O(n), S: O(n)
func countBinarySubstrings(s string) int {
	list := make([]int, 0)
	count := 1
	for i := 1; i < len(s); i++ {
		if s[i] == s[i-1] {
			count++
		} else {
			list = append(list, count)
			count = 1
		}
	}
	list = append(list, count)
	result := 0
	for i := 1; i < len(list); i++ {
		result += min(list[i], list[i-1])
	}
	return result
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	var s1 = "00110011"
	var s2 = "10101"
	fmt.Println(countBinarySubstrings(s1)) // 6
	fmt.Println(countBinarySubstrings(s2)) // 4
}
