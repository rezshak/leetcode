// https://leetcode.com/problems/climbing-stairs/

package main

import "fmt"

// T: O(n), S: O(1)
func climbStairs(n int) int {
	if n < 3 {
		return n
	}
	a, b, sum := 1, 2, 0
	for i := 3; i <= n; i++ {
		sum = a + b
		a = b
		b = sum
	}
	return sum
}

// T: O(n), S: O(n)
func climbStairsDp(n int) int {
	if n == 0 || n == 1 {
		return n
	}
	dp := make([]int, n+1)
	dp[1] = 1
	dp[2] = 2
	for i := 3; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}

// T: O(n), S: O(n)
func climbStairsMemo(n int) int {
	memo := make([]int, n+1)
	return helperMemo(0, n, memo)
}

func helperMemo(i, n int, memo []int) int {
	if i > n {
		return 0
	}
	if i == n {
		return 1
	}
	if memo[i] > 0 {
		return memo[i]
	}
	memo[i] = helperMemo(i+1, n, memo) + helperMemo(i+2, n, memo)
	return memo[i]
}

// T: O(n^2), S: O(n)
func climbStairsBrute(n int) int {
	if n < 3 {
		return n
	}
	return climbStairsBrute(n-1) + (n - 2)
}

func main() {
	fmt.Println(climbStairs(3))      // 3
	fmt.Println(climbStairsDp(3))    // 3
	fmt.Println(climbStairsMemo(3))  // 3
	fmt.Println(climbStairsBrute(3)) // 3
	fmt.Println(climbStairs(4))      // 5
	fmt.Println(climbStairsDp(4))    // 5
	fmt.Println(climbStairsMemo(4))  // 5
	fmt.Println(climbStairsBrute(4)) // 5
}
