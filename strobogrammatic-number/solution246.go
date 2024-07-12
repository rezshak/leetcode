// https://leetcode.com/problems/strobogrammatic-number/

package main

import (
	"fmt"
)

var strobMap = map[rune]rune{
	'0': '0',
	'1': '1',
	'6': '9',
	'8': '8',
	'9': '6',
}

// T: O(n), S: O(1)
func isStrobogrammatic(num string) bool {
	left, right := 0, len(num)-1
	for left <= right {
		leftChar, rightChar := rune(num[left]), rune(num[right])
		mappedChar, ok := strobMap[leftChar]
		if !ok || mappedChar != rightChar {
			return false
		}
		left++
		right--
	}
	return true
}

func main() {
	fmt.Println(isStrobogrammatic("69"))  // true
	fmt.Println(isStrobogrammatic("88"))  // true
	fmt.Println(isStrobogrammatic("962")) // false
	fmt.Println(isStrobogrammatic("808")) // true
	fmt.Println(isStrobogrammatic("2"))   // false
}
