// https://leetcode.com/problems/string-compression/

package main

import (
	"fmt"
	"strconv"
)

// T: O(n), S: O(1)
func compress(chars []byte) int {
	len := len(chars)
	resultIdx := 0
	idx := 0
	for idx < len {
		currChar := chars[idx]
		count := 0
		for idx < len && chars[idx] == currChar {
			idx++
			count++
		}
		chars[resultIdx] = currChar
		resultIdx++
		if count != 1 {
			for _, c := range strconv.Itoa(count) {
				chars[resultIdx] = byte(c)
				resultIdx++
			}
		}
	}
	return resultIdx
}

func main() {
	chars1 := []byte{'a', 'a', 'b', 'b', 'c', 'c', 'c'}
	chars2 := []byte{'a'}
	chars3 := []byte{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}
	fmt.Println(compress(chars1))
	fmt.Println(string(chars1[:compress(chars1)])) // "a2b2c3"
	fmt.Println(compress(chars2))
	fmt.Println(string(chars2[:compress(chars2)])) // "a"
	fmt.Println(compress(chars3))
	fmt.Println(string(chars3[:compress(chars3)])) // "ab12"
}
