// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func maxProfit(prices []int) int {
	n, maxProfit := len(prices), 0
	for buy, sell := 0, 1; sell < n; sell++ {
		if prices[buy] < prices[sell] {
			currProfit := prices[sell] - prices[buy]
			maxProfit = max(maxProfit, currProfit)
		} else {
			buy = sell
		}
	}
	return maxProfit
}

func main() {
	var prices1 = []int{7, 1, 5, 3, 6, 4}
	var prices2 = []int{7, 6, 4, 3, 1}
	fmt.Println(maxProfit(prices1)) // 5
	fmt.Println(maxProfit(prices2)) // 0
}
