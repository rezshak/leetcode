// https://leetcode.com/problems/basic-calculator/

package main

import (
	"fmt"
	"strconv"
	"unicode"
)

// T: O(n), S: O(n)
func calculate(s string) int {
	st := []int{}
	num, result, sign := 0, 0, 1

	for _, ch := range s {
		if unicode.IsDigit(ch) {
			digit, _ := strconv.Atoi(string(ch))
			num = num*10 + digit
		} else if ch == '+' {
			result += num * sign
			sign = 1
			num = 0
		} else if ch == '-' {
			result += num * sign
			sign = -1
			num = 0
		} else if ch == '(' {
			st = append(st, result)
			st = append(st, sign)
			result = 0
			sign = 1
		} else if ch == ')' {
			result += num * sign
			sign = st[len(st)-1]
			st = st[:len(st)-1]
			result = result*sign + st[len(st)-1]
			st = st[:len(st)-1]
			num = 0
		}
	}
	result += num * sign
	return result
}

func main() {
	s1 := "1 + 1"
	s2 := " 2-1 + 2 "
	s3 := "(1+(4+5+2)-3)+(6+8)"
	fmt.Println(calculate(s1)) // 2
	fmt.Println(calculate(s2)) // 3
	fmt.Println(calculate(s3)) // 23
}
