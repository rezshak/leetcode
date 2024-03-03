// https://leetcode.com/problems/number-of-1-bits/

package main

import (
	"fmt"
)

// T: O(1), S: O(1)
func hammingWeight(n int) int {
	count := 0
	mask := 1
	for i := 0; i < 32; i++ {
		if n&mask != 0 {
			count++
		}
		n >>= 1
	}
	return count
}

func main() {
	n1 := 00000000000000000000000000001011
	n2 := 00000000000000000000000010000000
	fmt.Println(hammingWeight(n1)) // 3
	fmt.Println(hammingWeight(n2)) // 1
}
