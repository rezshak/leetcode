// https://leetcode.com/problems/fibonacci-number/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func fib(n int) int {
	if n == 0 || n == 1 {
		return n
	}
	fib, a, b := 0, 0, 1
	for i := 2; i <= n; i++ {
		fib = a + b
		a = b
		b = fib
	}
	return fib
}

// T: O(n), S: O(n)
func fibDp(n int) int {
	if n == 0 || n == 1 {
		return n
	}
	dp := make([]int, n+1)
	dp[0] = 0
	dp[1] = 1
	for i := 2; i <= n; i++ {
		dp[i] = dp[i-2] + dp[i-1]
	}
	return dp[n]
}

// T: O(n), S: O(n)
func fibRecMemo(n int) int {
	memo := map[int]int{0: 0, 1: 1}
	return helper(n, memo)
}

func helper(n int, memo map[int]int) int {
	if val, ok := memo[n]; ok {
		return val
	}
	memo[n] = helper(n-1, memo) + helper(n-2, memo)
	return memo[n]
}

// T: O(2^n), S: O(n)
func fibRec(n int) int {
	if n == 0 || n == 1 {
		return n
	}
	return fibRec(n-1) + fibRec(n-2)
}

func main() {
	fmt.Println(fib(2)) // 1
	fmt.Println(fib(3)) // 2
	fmt.Println(fib(4)) // 3

	fmt.Println(fibDp(2)) // 1
	fmt.Println(fibDp(3)) // 2
	fmt.Println(fibDp(4)) // 3

	fmt.Println(fibRecMemo(0)) // 0
	fmt.Println(fibRecMemo(2)) // 1
	fmt.Println(fibRecMemo(3)) // 2
	fmt.Println(fibRecMemo(4)) // 3

	fmt.Println(fibRec(2)) // 1
	fmt.Println(fibRec(3)) // 2
	fmt.Println(fibRec(4)) // 3
}
