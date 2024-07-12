// https://leetcode.com/problems/asteroid-collision/

package main

import (
	"fmt"
)

// T: O(n), S: O(n)
func asteroidCollision(asteroids []int) []int {
	stack := []int{}
	for _, ast := range asteroids {
		if ast > 0 {
			stack = append(stack, ast)
		} else {
			for len(stack) != 0 && stack[len(stack)-1] > 0 && stack[len(stack)-1] < -ast {
				stack = stack[:len(stack)-1]
			}
			if len(stack) == 0 || stack[len(stack)-1] < 0 {
				stack = append(stack, ast)
			} else if stack[len(stack)-1] == -ast {
				stack = stack[:len(stack)-1]
			}
		}
	}

	ans := make([]int, len(stack))
	for i := len(stack) - 1; i >= 0; i-- {
		ans[i], stack = stack[len(stack)-1], stack[:len(stack)-1]
	}
	return ans
}

func main() {
	asteroids1 := []int{5, 10, -5}
	asteroids2 := []int{8, -8}
	fmt.Println(asteroidCollision(asteroids1)) // [5, 10]
	fmt.Println(asteroidCollision(asteroids2)) // []
}
