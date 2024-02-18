// https://leetcode.com/problems/lexicographically-smallest-palindrome/

package main

import "fmt"

// T: O(n), S: O(n)
func makeSmallestPalindrome(str string) string {
	arr := []rune(str)
	left, right := 0, len(arr)-1
	for left < right {
		if arr[left] > arr[right] {
			arr[left] = arr[right]
		} else {
			arr[right] = arr[left]
		}
		left++
		right--
	}
	return string(arr)
}

func main() {
	s1 := "egcfe"
	fmt.Println(makeSmallestPalindrome(s1))
}
