// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

package main

import (
	"fmt"
	"strings"
)

// T: O(n), S: O(1)
func maxScore(s string) int {
	ones := strings.Count(s, "1")
	ans := 0
	zeros := 0
	for i := 0; i < len(s)-1; i++ {
		if s[i] == '1' {
			ones--
		} else {
			zeros++
		}
		ans = max(ans, zeros+ones)
	}
	return ans
}

// T: O(n), S: O(n)
func maxScore2(s string) int {
	n := len(s)
	zeros := make([]int, n)
	ones := make([]int, n)
	zCount := 0
	oCount := 0
	for i := 0; i < n; i++ {
		if s[i] == '0' {
			zCount++
			zeros[i] = zCount
		}
		if s[n-i-1] == '1' {
			oCount++
			ones[n-i-1] = oCount
		}
	}
	ans := 0
	for i := 0; i < n-1; i++ {
		ans = max(ans, zeros[i]+ones[i+1])
	}
	return ans
}

// T: O(n^2), S: O(1)
func maxScoreBrute(s string) int {
	ans := 0
	n := len(s)
	for i := 1; i < n; i++ {
		leftScore := score(s, 0, i, '0')
		rightScore := score(s, i, n, '1')
		ans = max(ans, leftScore+rightScore)
	}
	return ans
}

// T: O(n), S: O(1)
func score(s string, start int, end int, v rune) int {
	score := 0
	for _, c := range s[start:end] {
		if c == v {
			score++
		}
	}
	return score
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Println(maxScore("011101")) // 5
	fmt.Println(maxScore("00111"))  // 5
	fmt.Println(maxScore("1111"))   // 3
	fmt.Println(maxScore("00"))     // 1
}
