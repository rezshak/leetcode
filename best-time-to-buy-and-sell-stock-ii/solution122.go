// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func maxProfit(prices []int) int {
	maxProfit := 0
	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i-1] {
			currProfit := prices[i] - prices[i-1]
			maxProfit += currProfit
		}
	}
	return maxProfit
}

func main() {
	prices1 := []int{7, 1, 5, 3, 6, 4}
	prices2 := []int{1, 2, 3, 4, 5}
	prices3 := []int{7, 6, 4, 3, 1}
	fmt.Println(maxProfit(prices1)) // 7
	fmt.Println(maxProfit(prices2)) // 4
	fmt.Println(maxProfit(prices3)) // 0
}
