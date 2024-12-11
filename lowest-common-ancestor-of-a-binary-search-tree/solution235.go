// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// T: O(h), S: O(1)
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || p == nil || q == nil {
		return nil
	}

	curr := root

	for curr != nil {
		if p.Val < curr.Val && q.Val < curr.Val {
			curr = curr.Left
		} else if p.Val > curr.Val && q.Val > curr.Val {
			curr = curr.Right
		} else {
			return curr
		}
	}

	return nil
}

// T: O(h), S: O(h)
func lowestCommonAncestorRec(root, p, q *TreeNode) *TreeNode {
	if p.Val < root.Val && q.Val < root.Val {
		return lowestCommonAncestorRec(root.Left, p, q)
	}

	if p.Val > root.Val && q.Val > root.Val {
		return lowestCommonAncestorRec(root.Right, p, q)
	}

	return root
}

func printTreeInorder(root *TreeNode) {
	if root == nil {
		return
	}
	printTreeInorder(root.Left)
	fmt.Printf("%d ", root.Val)
	printTreeInorder(root.Right)
}

func main() {
	root1 := &TreeNode{Val: 6}
	root1.Left = &TreeNode{Val: 2}
	root1.Right = &TreeNode{Val: 8}
	root1.Left.Left = &TreeNode{Val: 0}
	root1.Left.Right = &TreeNode{Val: 4}
	root1.Left.Right.Left = &TreeNode{Val: 3}
	root1.Left.Right.Right = &TreeNode{Val: 5}
	root1.Right.Left = &TreeNode{Val: 7}
	root1.Right.Right = &TreeNode{Val: 9}

	p1 := &TreeNode{Val: 2}
	q1 := &TreeNode{Val: 8}
	lca1 := lowestCommonAncestor(root1, p1, q1) // 6
	fmt.Println(lca1.Val)
	lca1 = lowestCommonAncestorRec(root1, p1, q1) // 6
	fmt.Println(lca1.Val)

	p2 := &TreeNode{Val: 2}
	q2 := &TreeNode{Val: 4}
	lca2 := lowestCommonAncestor(root1, p2, q2) // 2
	fmt.Println(lca2.Val)
	lca2 = lowestCommonAncestorRec(root1, p2, q2) // 2
	fmt.Println(lca2.Val)
}
