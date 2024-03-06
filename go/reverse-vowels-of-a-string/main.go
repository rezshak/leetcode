// https://leetcode.com/problems/reverse-vowels-of-a-string/

package main

import "fmt"

var vowels = map[rune]bool{
	'a': true, 'e': true, 'i': true, 'o': true, 'u': true,
	'A': true, 'E': true, 'I': true, 'O': true, 'U': true,
}

// T: O(n), S: O(n)
func reverseVowels(s string) string {
	arr := []rune(s)
	left, right := 0, len(s)-1
	for left < right {
		if !vowels[arr[left]] {
			left++
		} else if !vowels[arr[right]] {
			right--
		} else {
			arr[left], arr[right] = arr[right], arr[left]
			left++
			right--
		}
	}
	return string(arr)
}

func main() {
	s1 := "hello"
	fmt.Println(reverseVowels(s1)) // "holle"
	s2 := "leetcode"
	fmt.Println(reverseVowels(s2)) // "leotcede"
}
