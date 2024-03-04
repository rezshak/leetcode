// https://leetcode.com/problems/greatest-common-divisor-of-strings/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func gcdOfStrings(str1, str2 string) string {
	if str1+str2 != str2+str1 {
		return ""
	}
	gcdLen := gcd(len(str1), len(str2))
	return str1[:gcdLen]
}

// T: O(log(min(a, b))), S: O(1)
func gcd(a, b int) int {
	if b == 0 {
		return a
	}
	return gcd(b, a%b)
}

func main() {
	s1 := "ABCABC"
	s2 := "ABC"
	fmt.Println(gcdOfStrings(s1, s2)) // ABC
	s1 = "ABABAB"
	s2 = "ABAB"
	fmt.Println(gcdOfStrings(s1, s2)) // AB
	s1 = "LEET"
	s2 = "CODE"
	fmt.Println(gcdOfStrings(s1, s2)) // ""
}
