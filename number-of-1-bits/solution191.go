// https://leetcode.com/problems/number-of-1-bits/

package main

import (
	"fmt"
)

// T: O(1), S: O(1)
func hammingWeight(n int) int {
	count, mask := 0, 1
	for i := 0; i < 32; i++ {
		if n&mask == 1 {
			count++
		}
		n >>= 1
	}
	return count
}

// T: O(1), S: O(1)
func hammingWeightMaskShifting(n int) int {
	count, mask := 0, 1
	for i := 0; i < 32; i++ {
		if n&mask != 0 {
			count++
		}
		mask <<= 1
	}
	return count
}

func main() {
	n1 := int(00000000000000000000000000001011)
	n2 := int(00000000000000000000000010000000)
	fmt.Println(hammingWeight(n1))             // 3
	fmt.Println(hammingWeightMaskShifting(n1)) // 3
	fmt.Println(hammingWeight(n2))             // 1
	fmt.Println(hammingWeightMaskShifting(n2)) // 1
}
