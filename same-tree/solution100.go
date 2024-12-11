// https://leetcode.com/problems/same-tree/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(min(n,m)), S: O(min(h1,h2))
func isSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	}

	if p == nil || q == nil {
		return false
	}

	if p.Val != q.Val {
		return false
	}

	return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
}

// T: O(min(n,m)), S: O(min(w1,w2))
func isSameTreeBfs(p *TreeNode, q *TreeNode) bool {
	queue1 := []*TreeNode{p}
	queue2 := []*TreeNode{q}

	for len(queue1) > 0 && len(queue2) > 0 {
		node1 := queue1[0]
		node2 := queue2[0]
		queue1 = queue1[1:]
		queue2 = queue2[1:]

		if node1 == nil && node2 == nil {
			continue
		}

		if node1 == nil || node2 == nil || node1.Val != node2.Val {
			return false
		}

		queue1 = append(queue1, node1.Left)
		queue2 = append(queue2, node2.Left)

		queue1 = append(queue1, node1.Right)
		queue2 = append(queue2, node2.Right)
	}

	return len(queue1) == 0 && len(queue2) == 0
}

func main() {
	p1 := &TreeNode{Val: 1}
	p1.Left = &TreeNode{Val: 2}
	p1.Right = &TreeNode{Val: 3}
	q1 := &TreeNode{Val: 1}
	q1.Left = &TreeNode{Val: 2}
	q1.Right = &TreeNode{Val: 3}
	fmt.Println(isSameTree(p1, q1))    // true
	fmt.Println(isSameTreeBfs(p1, q1)) // true

	p2 := &TreeNode{Val: 1}
	p2.Left = &TreeNode{Val: 2}
	p2.Right = nil
	q2 := &TreeNode{Val: 1}
	q2.Left = nil
	q2.Right = &TreeNode{Val: 3}
	fmt.Println(isSameTree(p2, q2))    // false
	fmt.Println(isSameTreeBfs(p2, q2)) // false
}
