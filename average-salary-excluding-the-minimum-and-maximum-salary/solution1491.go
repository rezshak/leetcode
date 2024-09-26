// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

package main

import "fmt"

// T: O(n), S: O(1)
func average(salary []int) float64 {
	minS, maxS, n := salary[0], salary[0], len(salary)
	totalS := 0
	for _, s := range salary {
		minS = min(minS, s)
		maxS = max(maxS, s)
		totalS += s
	}
	totalS -= minS
	totalS -= maxS
	avgS := float64(totalS) / float64((n - 2))
	return avgS
}

func main() {
	salary1 := []int{4000, 3000, 1000, 2000}
	salary2 := []int{1000, 2000, 3000}
	fmt.Println(average(salary1)) // 2500.0
	fmt.Println(average(salary2)) // 2000.0
}
