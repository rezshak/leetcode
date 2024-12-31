// https://leetcode.com/problems/nested-list-weight-sum/

// https://leetcode.com/problems/nested-list-weight-sum/

package main

import (
	"fmt"
)

type NestedInteger struct {
	value *int
	list  []*NestedInteger
}

func NewNestedInteger(value int) *NestedInteger {
	return &NestedInteger{value: &value}
}

func NewNestedList(list []*NestedInteger) *NestedInteger {
	return &NestedInteger{list: list}
}

func (ni *NestedInteger) IsInteger() bool {
	return ni.value != nil
}

func (ni *NestedInteger) GetInteger() int {
	if ni.value != nil {
		return *ni.value
	}
	return 0
}

func (ni *NestedInteger) GetList() []*NestedInteger {
	return ni.list
}

// T: O(n), S: O(d)
func depthSum(nestedList []*NestedInteger) int {
	return dfs(nestedList, 1)
}

func dfs(list []*NestedInteger, depth int) int {
	sum := 0
	for _, nested := range list {
		if nested.IsInteger() {
			sum += nested.GetInteger() * depth
		} else {
			sum += dfs(nested.GetList(), depth+1)
		}
	}
	return sum
}

// T: O(n), S: O(n)
func depthSumBfs(nestedList []*NestedInteger) int {
	queue := nestedList
	depth := 1
	total := 0

	for len(queue) > 0 {
		size := len(queue)
		for i := 0; i < size; i++ {
			nested := queue[0]
			queue = queue[1:]
			if nested.IsInteger() {
				total += nested.GetInteger() * depth
			} else {
				queue = append(queue, nested.GetList()...)
			}
		}
		depth++
	}
	return total
}

func main() {
	// Create nested list [[1,1],2,[1,1]]
	nestedList := []*NestedInteger{
		NewNestedList([]*NestedInteger{NewNestedInteger(1), NewNestedInteger(1)}),
		NewNestedInteger(2),
		NewNestedList([]*NestedInteger{NewNestedInteger(1), NewNestedInteger(1)}),
	}

	fmt.Println(depthSum(nestedList))    // 10
	fmt.Println(depthSumBfs(nestedList)) // 10
}
