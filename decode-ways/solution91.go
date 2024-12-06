// https://leetcode.com/problems/decode-ways/

package main

import (
	"fmt"
)

// T: O(2^n), S: O(n)
func numDecodingsRec(s string) int {
	return dfsRec(0, s)
}

// T: O(2^n), S: O(n)
func dfsRec(i int, s string) int {
	if i == len(s) {
		return 1
	}
	if s[i] == '0' {
		return 0
	}

	res := dfsRec(i+1, s)
	if i < len(s)-1 {
		if s[i] == '1' || (s[i] == '2' && s[i+1] < '7') {
			res += dfsRec(i+2, s)
		}
	}
	return res
}

// T: O(n), S: O(n)
func numDecodingsDpTopDown(s string) int {
	dp := make(map[int]int)
	dp[len(s)] = 1
	return dfsDp(s, 0, dp)
}

// T: O(n), S: O(n)
func dfsDp(s string, i int, dp map[int]int) int {
	if val, ok := dp[i]; ok {
		return val
	}
	if s[i] == '0' {
		return 0
	}

	res := dfsDp(s, i+1, dp)
	if i+1 < len(s) && (s[i] == '1' || s[i] == '2' && s[i+1] < '7') {
		res += dfsDp(s, i+2, dp)
	}
	dp[i] = res
	return res
}

// T: O(n), S: O(n)
func numDecodingsDpBottomUp(s string) int {
	dp := make([]int, len(s)+1)
	dp[len(s)] = 1
	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == '0' {
			dp[i] = 0
		} else {
			dp[i] = dp[i+1]
			if i+1 < len(s) && (s[i] == '1' || s[i] == '2' && s[i+1] < '7') {
				dp[i] += dp[i+2]
			}
		}
	}
	return dp[0]
}

// T: O(n), S: O(1)
func numDecodingsDpBottomUpOpt(s string) int {
	dp, dp2 := 0, 0
	dp1 := 1
	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == '0' {
			dp = 0
		} else {
			dp = dp1
			if i+1 < len(s) && (s[i] == '1' || s[i] == '2' && s[i+1] < '7') {
				dp += dp2
			}
		}
		dp2 = dp1
		dp1 = dp
		dp = 0
	}
	return dp1
}

func main() {
	s1 := "12"
	fmt.Println(numDecodingsDpTopDown(s1)) // 2
	fmt.Println(numDecodingsRec(s1)) // 2
	fmt.Println(numDecodingsDpBottomUp(s1)) // 2
	fmt.Println(numDecodingsDpBottomUpOpt(s1)) // 2
	s2 := "226"
	fmt.Println(numDecodingsDpTopDown(s2)) // 3
	fmt.Println(numDecodingsRec(s2)) // 3
	fmt.Println(numDecodingsDpBottomUp(s2)) // 3
	fmt.Println(numDecodingsDpBottomUpOpt(s2)) // 3
	s3 := "06"
	fmt.Println(numDecodingsDpTopDown(s3)) // 0
	fmt.Println(numDecodingsRec(s3)) // 0
	fmt.Println(numDecodingsDpBottomUp(s3)) // 0
	fmt.Println(numDecodingsDpBottomUpOpt(s3)) // 0
}
