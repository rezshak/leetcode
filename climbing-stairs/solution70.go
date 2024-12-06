// https://leetcode.com/problems/climbing-stairs/

package main

import "fmt"

// T: O(n^2), S: O(n)
func climbStairsRec(n int) int {
	if n < 3 {
		return n
	}
	return climbStairsRec(n-1) + climbStairsRec(n-2)
}

// T: O(n), S: O(n)
func climbStairsMemo(n int) int {
	memo := make([]int, n+1)
	return helperMemo(n, memo)
}

func helperMemo(n int, memo []int) int {
	if memo[n] > 0 {
		return memo[n]
	}
	if n < 3 {
		memo[n] = n
		return n
	}
	memo[n] = helperMemo(n-1, memo) + helperMemo(n-2, memo)
	return memo[n]
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

// T: O(n), S: O(1)
func climbStairsDpBottomUpOpt(n int) int {
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

func main() {
	fmt.Println(climbStairsRec(3))           // 3
	fmt.Println(climbStairsMemo(3))          // 3
	fmt.Println(climbStairsDp(3))            // 3
	fmt.Println(climbStairsDpBottomUpOpt(3)) // 3
	fmt.Println(climbStairsRec(4))           // 5
	fmt.Println(climbStairsMemo(4))          // 5
	fmt.Println(climbStairsDp(4))            // 5
	fmt.Println(climbStairsDpBottomUpOpt(4)) // 5
}
