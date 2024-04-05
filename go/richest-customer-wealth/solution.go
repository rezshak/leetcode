// https://leetcode.com/problems/richest-customer-wealth/

package main

import (
	"fmt"
)

// T: O(n), S: O(1)
func maximumWealth(accounts [][]int) int {
	maxWealth := 0
	for _, acct := range accounts {
		acctSum := 0
		for _, bal := range acct {
			acctSum += bal
		}
		if acctSum > maxWealth {
			maxWealth = acctSum
		}
	}
	return maxWealth
}

func main() {
	accts1 := [][]int{
		{1, 2, 3},
		{3, 2, 1},
	}
	fmt.Println(maximumWealth(accts1)) // 6
}
