// https://leetcode.com/problems/number-of-1-bits/

package main

import (
	"fmt"
)

// T: O(1), S: O(1)
func hammingWeight(n uint32) int {
	count := 0
	mask := uint32(1)
	for i := 0; i < 32; i++ {
		if n&mask != 0 {
			count++
		}
		n >>= 1
	}
	return count
}

func main() {
	n1 := uint32(00000000000000000000000000001011)
	n2 := uint32(00000000000000000000000010000000)
	fmt.Println(hammingWeight(n1)) // 3
	fmt.Println(hammingWeight(n2)) // 1
}
