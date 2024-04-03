// https://leetcode.com/problems/string-to-integer-atoi/
package main

import (
	"fmt"
	"math"
	"unicode"
)

// T: O(n), S:O(1)
func myAtoi(s string) int {
	result := 0
	sign := 1
	i := 0

	for i < len(s) && s[i] == ' ' {
		i++
	}

	if i < len(s) && (s[i] == '-' || s[i] == '+') {
		if s[i] == '-' {
			sign = -1
		}
		i++
	}

	for i < len(s) && unicode.IsDigit(rune(s[i])) {
		digit := int(s[i] - '0')

		if result > (math.MaxInt32-digit)/10 {
			if sign == 1 {
				return math.MaxInt32
			}
			return math.MinInt32
		}

		result = result*10 + digit
		i++
	}

	return sign * result
}

func main() {
	fmt.Println(myAtoi("42"))              // 42
	fmt.Println(myAtoi("   -42"))          // -42
	fmt.Println(myAtoi("4193 with words")) // 4193
	fmt.Println(myAtoi("words and 987"))   // 0
	fmt.Println(myAtoi("-91283472332"))    // -2147483648
}
