// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func maxProfit(prices []int) int {
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
	fmt.Println(maxProfit(prices1)) // 5
	fmt.Println(maxProfit(prices2)) // 0
}
