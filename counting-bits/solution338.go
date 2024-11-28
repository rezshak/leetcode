// https://leetcode.com/problems/counting-bits/

package main

import (
	"fmt"
)

// T: O(nlogn), S: O(n)
func countBits(n int) []int {
	ans := make([]int, n+1)
	for i := 0; i <= n; i++ {
		ans[i] = count1Bits(i)
	}
	return ans
}

func count1Bits(n int) int {
	count := 0
	for n != 0 {
		if n&1 == 1 {
			count++
		}
		n >>= 1
	}
	return count
}

func main() {
	fmt.Println(countBits(2)) // [0, 1, 1]
	fmt.Println(countBits(5)) // [0, 1, 1, 2, 1, 2]
}
