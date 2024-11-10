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
	l, r := 0, len(num)-1
	for l <= r {
		lch, rch := rune(num[l]), rune(num[r])
		mappedChar, ok := strobMap[lch]
		if !ok || mappedChar != rch {
			return false
		}
		l++
		r--
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
