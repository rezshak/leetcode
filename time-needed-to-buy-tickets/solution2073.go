// https://leetcode.com/problems/time-needed-to-buy-tickets/

package main

import "fmt"

// T: O(n^2), S: O(1)
func timeRequiredToBuy(tickets []int, k int) int {
	result, n := 0, len(tickets)
	for tickets[k] > 0 {
		for i := 0; i < n; i++ {
			if tickets[i] > 0 {
				tickets[i]--
				result++
				if tickets[k] == 0 {
					return result
				}
			}
		}
	}
	return result
}

func main() {
	nums1 := []int{2, 3, 2}
	nums2 := []int{5, 1, 1, 1}
	fmt.Println(timeRequiredToBuy(nums1, 2)) // 6
	fmt.Println(timeRequiredToBuy(nums2, 0)) // 8
}
