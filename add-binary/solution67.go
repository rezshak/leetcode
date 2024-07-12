// https://leetcode.com/problems/add-binary/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(n)
func addBinary(a string, b string) string {
	i, j := len(a)-1, len(b)-1
	carry := 0
	var sb strings.Builder
	for i >= 0 || j >= 0 {
		x := 0
		if i >= 0 {
			x = int(a[i] - '0')
		}
		y := 0
		if j >= 0 {
			y = int(b[j] - '0')
		}
		sum := x + y + carry
		digit := sum % 2
		sb.WriteString(fmt.Sprintf("%d", digit))
		carry = sum / 2
		i--
		j--
	}
	if carry > 0 {
		sb.WriteString(fmt.Sprintf("%d", carry))
	}
	return reverse(sb.String())
}

func reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	s1, s2 := "11", "1" // 100
	fmt.Println(addBinary(s1, s2))
}
