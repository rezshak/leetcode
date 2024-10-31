// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func maxProfit(prices []int) int {
	n := len(prices)
	rightMaxes := make([]int, n)
	rightMaxes[n-1] = prices[n-1]
	for i := n - 2; i >= 0; i-- {
		rightMaxes[i] = max(rightMaxes[i+1], prices[i])
	}
	maxProfit := 0
	for i := 0; i < n; i++ {
		currProfit := rightMaxes[i] - prices[i]
		maxProfit = max(maxProfit, currProfit)
	}
	return maxProfit
}

// T: O(n), S: O(1)
func maxProfitOpt(prices []int) int {
	l, r, n := 0, 1, len(prices)
	res := 0
	for r < n {
		if prices[l] < prices[r] {
			res = max(res, prices[r]-prices[l])
		} else {
			l = r
		}
		r++
	}
	return res
}

func main() {
	var prices1 = []int{7, 1, 5, 3, 6, 4}
	var prices2 = []int{7, 6, 4, 3, 1}
	fmt.Println(maxProfit(prices1))    // 5
	fmt.Println(maxProfit(prices2))    // 0
	fmt.Println(maxProfitOpt(prices1)) // 5
	fmt.Println(maxProfitOpt(prices2)) // 0
}
