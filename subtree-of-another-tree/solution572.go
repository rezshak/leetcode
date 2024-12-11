// https://leetcode.com/problems/subtree-of-another-tree/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(m*n), S: O(h)
func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	if subRoot == nil {
		return true
	}
	if root == nil {
		return false
	}
	if isSameTree(root, subRoot) {
		return true
	}
	return isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot)
}

// T: O(m*n), S: O(w)
func isSubtreeBfs(root *TreeNode, subRoot *TreeNode) bool {
	if subRoot == nil {
		return true
	}
	if root == nil {
		return false
	}

	queue := []*TreeNode{root}

	for len(queue) > 0 {
		current := queue[0]
		queue = queue[1:]

		if isSameTree(current, subRoot) {
			return true
		}

		if current.Left != nil {
			queue = append(queue, current.Left)
		}
		if current.Right != nil {
			queue = append(queue, current.Right)
		}
	}

	return false
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

func main() {
	root1 := &TreeNode{Val: 3,
		Left: &TreeNode{Val: 4,
			Left:  &TreeNode{Val: 1},
			Right: &TreeNode{Val: 2}},
		Right: &TreeNode{Val: 5}}
	subRoot1 := &TreeNode{Val: 4,
		Left:  &TreeNode{Val: 1},
		Right: &TreeNode{Val: 2}}

	fmt.Println(isSubtree(root1, subRoot1))    // true
	fmt.Println(isSubtreeBfs(root1, subRoot1)) // true

	root2 := &TreeNode{Val: 3,
		Left: &TreeNode{Val: 4,
			Left:  &TreeNode{Val: 1},
			Right: &TreeNode{Val: 3}},
		Right: &TreeNode{Val: 5}}
	subRoot2 := &TreeNode{Val: 4,
		Left:  &TreeNode{Val: 1},
		Right: &TreeNode{Val: 2}}

	fmt.Println(isSubtree(root2, subRoot2))    // false
	fmt.Println(isSubtreeBfs(root2, subRoot2)) // false
}
