// https://leetcode.com/problems/divide-two-integers/

package main

import (
	"fmt"
	"math"
)

// T: O(log n), S: O(1)
func divide(dividend int, divisor int) int {
	if dividend == math.MinInt32 && divisor == -1 {
		return math.MaxInt32 // Overflow case
	}
	if divisor == 1 {
		return dividend
	}
	if divisor == -1 {
		return -dividend
	}

	isNegative := (dividend < 0) != (divisor < 0)

	absDividend := int64(math.Abs(float64(dividend)))
	absDivisor := int64(math.Abs(float64(divisor)))

	result := 0

	for absDividend >= absDivisor {
		temp := absDivisor
		multiple := int64(1)

		for absDividend >= (temp << 1) {
			temp <<= 1     // Double the temp value
			multiple <<= 1 // Double the multiple
		}

		absDividend -= temp
		result += int(multiple)
	}

	// Apply sign to result
	if isNegative {
		return -result
	}
	return result
}

func main() {
	fmt.Println(divide(10, 3)) // 3
	fmt.Println(divide(7, -3)) // -2
}
