// https://leetcode.com/problems/reverse-words-in-a-string-iii/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func reverseWords(s string) string {
	arr := strings.Fields(s)
	for i := 0; i < len(arr); i++ {
		arr[i] = reverseWord(arr[i])
	}
	return strings.Join(arr, " ")
}

func reverseWord(w string) string {
	left, right := 0, len(w)-1
	arr := []rune(w)
	for left < right {
		arr[left], arr[right] = arr[right], arr[left]
		left++
		right--
	}
	return string(arr)
}

// T: O(n), S: O(1)
func reverseWordsTwoPtr(s string) string {
	arr := []rune(s)
	lastSpaceIndex := -1
	len := len(s)
	for strIdx := 0; strIdx < len+1; strIdx++ {
		if strIdx == len || arr[strIdx] == ' ' {
			begIdx := lastSpaceIndex + 1
			endIdx := strIdx - 1
			for begIdx < endIdx {
				arr[begIdx], arr[endIdx] = arr[endIdx], arr[begIdx]
				begIdx++
				endIdx--
			}
			lastSpaceIndex = strIdx
		}
	}
	return string(arr)
}

func main() {
	var s1 = "Let's take LeetCode contest"
	fmt.Println(reverseWords(s1))
	fmt.Println(reverseWordsTwoPtr(s1))
}
