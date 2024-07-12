// https://leetcode.com/problems/base-7/

package main

import (
	"fmt"
	"strconv"
)

// T: O(log(n)), S: O(1)
func convertToBase7(num int) string {
	if num == 0 {
		return "0"
	}
	var res string
	absNum := abs(num)
	for absNum > 0 {
		res = strconv.Itoa(absNum%7) + res
		absNum /= 7
	}
	if num < 0 {
		res = "-" + res
	}
	return res
}

func abs(n int) int {
	if n < 0 {
		return -n
	}
	return n
}

func main() {
	num1 := 100
	num2 := -7
	fmt.Println(convertToBase7(num1)) // 202
	fmt.Println(convertToBase7(num2)) // -10
}
