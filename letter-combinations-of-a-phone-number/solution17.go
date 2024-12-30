// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

package main

import (
	"fmt"
)

var digitToLetters = []string{
	"",     // 0
	"",     // 1
	"abc",  // 2
	"def",  // 3
	"ghi",  // 4
	"jkl",  // 5
	"mno",  // 6
	"pqrs", // 7
	"tuv",  // 8
	"wxyz", // 9
}

// T: O(n4^n), S: O(n)
func letterCombinations(digits string) []string {
	var result []string
	if digits == "" {
		return result
	}
	backtrack(digits, 0, "", &result)
	return result
}

func backtrack(digits string, index int, current string, result *[]string) {
	if index == len(digits) {
		*result = append(*result, current)
		return
	}
	digit := digits[index] - '0'
	letters := digitToLetters[digit]

	for _, letter := range letters {
		backtrack(digits, index+1, current+string(letter), result)
	}
}

func main() {
	fmt.Println(letterCombinations("23")) // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
	fmt.Println(letterCombinations(""))   // []
	fmt.Println(letterCombinations("2"))  // ["a","b","c"]
}
