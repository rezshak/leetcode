// https://leetcode.com/problems/roman-to-integer/

package main

import "fmt"

var syms = map[byte]int{
	'I': 1,
	'V': 5,
	'X': 10,
	'L': 50,
	'C': 100,
	'D': 500,
	'M': 1000,
}

// T: O(n), S: O(1)
func romanToInt(s string) int {
	n, ans, i := len(s), 0, 0
	for i < n {
		currVal := syms[s[i]]
		nextVal := 0
		if i < n-1 {
			nextVal = syms[s[i+1]]
		}
		if currVal < nextVal {
			ans += (nextVal - currVal)
			i += 2
		} else {
			ans += currVal
			i++
		}
	}
	return ans
}

func main() {
	var s1 = "III"
	var s2 = "LVIII"
	var s3 = "MCMXCIV"
	fmt.Println(romanToInt(s1)) // 3
	fmt.Println(romanToInt(s2)) // 58
	fmt.Println(romanToInt(s3)) // 1994
}
