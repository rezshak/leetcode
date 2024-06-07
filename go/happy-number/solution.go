// https://leetcode.com/problems/happy-number/

package main

import (
	"fmt"
)

// T: O(log n), S: O(log n)
func isHappy(num int) bool {
	seen := make(map[int]bool)
	for num != 1 && !seen[num] {
		seen[num] = true
		num = squaredDigitsSum(num)
	}
	return num == 1
}

// T: O(log n), S: O(1)
func isHappyOpt(num int) bool {
	slow, fast := num, squaredDigitsSum(num)
	for fast != 1 && fast != slow {
		slow = squaredDigitsSum(slow)
		fast = squaredDigitsSum(squaredDigitsSum(fast))
	}
	return fast == 1
}

// T: O(log n), S: O(1)
func squaredDigitsSum(num int) int {
	result := 0
	for num > 0 {
		digit := num % 10
		squared := digit * digit
		result += squared
		num /= 10
	}
	return result
}

func main() {
	fmt.Println(isHappy(19))    // true
	fmt.Println(isHappy(2))     // false
	fmt.Println(isHappyOpt(19)) // true
	fmt.Println(isHappyOpt(2))  // false
}
