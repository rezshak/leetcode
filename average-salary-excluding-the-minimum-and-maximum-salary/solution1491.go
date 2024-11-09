// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

package main

import "fmt"

// T: O(n), S: O(1)
func average(salary []int) float64 {
	minSal, maxSal, n := salary[0], salary[0], len(salary)
	sum := 0
	for _, sal := range salary {
		minSal = min(minSal, sal)
		maxSal = max(maxSal, sal)
		sum += sal
	}
	sum -= minSal
	sum -= maxSal
	avgSal := float64(sum) / float64(n-2)
	return avgSal
}

func main() {
	salary1 := []int{4000, 3000, 1000, 2000}
	salary2 := []int{1000, 2000, 3000}
	fmt.Println(average(salary1)) // 2500.0
	fmt.Println(average(salary2)) // 2000.0
}
