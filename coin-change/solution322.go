// https://leetcode.com/problems/coin-change/

package main

import (
	"fmt"
	"math"
)

// T: O(n^amt), S: O(amt)
func coinChangeRec(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}
	return dfsRec(coins, amount)
}

func dfsRec(coins []int, remainingAmount int) int {
	if remainingAmount < 0 {
		return -1
	}
	if remainingAmount == 0 {
		return 0
	}

	minCoins := math.MaxInt32

	for _, coin := range coins {
		subResult := dfsRec(coins, remainingAmount-coin)
		if subResult != -1 {
			minCoins = int(math.Min(float64(minCoins), float64(subResult+1)))
		}
	}

	if minCoins == math.MaxInt32 {
		return -1
	}
	return minCoins
}

// T: O(n*amt), S: O(amt)
func coinChangeRecMemo(coins []int, amount int) int {
	memo := make(map[int]int)
	return dfsRecMemo(coins, amount, memo)
}

func dfsRecMemo(coins []int, remainingAmount int, memo map[int]int) int {
	if val, found := memo[remainingAmount]; found {
		return val
	}

	if remainingAmount < 0 {
		return -1
	}
	if remainingAmount == 0 {
		return 0
	}

	minCoins := math.MaxInt32

	for _, coin := range coins {
		subResult := dfsRecMemo(coins, remainingAmount-coin, memo)
		if subResult != -1 {
			minCoins = int(math.Min(float64(minCoins), float64(subResult+1)))
		}
	}

	result := minCoins
	if minCoins == math.MaxInt32 {
		result = -1
	}

	// Memoize and return the result
	memo[remainingAmount] = result
	return result
}

// T: O(n*amt), S: O(amt)
func coinChangeDpBottomUp(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}

	dp := make([]int, amount+1)
	for i := range dp {
		dp[i] = amount + 1
	}

	dp[0] = 0

	for i := 1; i <= amount; i++ {
		for _, coin := range coins {
			if coin <= i {
				dp[i] = int(math.Min(float64(dp[i]), float64(dp[i-coin]+1)))
			}
		}
	}

	if dp[amount] > amount {
		return -1
	}
	return dp[amount]
}

func main() {
	coins1 := []int{1, 2, 5}
	amount1 := 11
	fmt.Println(coinChangeRec(coins1, amount1))        // 3 (5 + 5 + 1)
	fmt.Println(coinChangeRecMemo(coins1, amount1))    // 3 (5 + 5 + 1)
	fmt.Println(coinChangeDpBottomUp(coins1, amount1)) // 3 (5 + 5 + 1)
	coins2 := []int{2}
	amount2 := 3
	fmt.Println(coinChangeRec(coins2, amount2))        // -1
	fmt.Println(coinChangeRecMemo(coins2, amount2))    // -1
	fmt.Println(coinChangeDpBottomUp(coins2, amount2)) // -1
	coins3 := []int{1}
	amount3 := 0
	fmt.Println(coinChangeRec(coins3, amount3))        // 0
	fmt.Println(coinChangeRecMemo(coins3, amount3))    // 0
	fmt.Println(coinChangeDpBottomUp(coins3, amount3)) // 0
}
